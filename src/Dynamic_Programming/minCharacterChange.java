package Dynamic_Programming;

import java.util.Arrays;

public class minCharacterChange {
    public static int palindromePartition(String s, int k) {
        int l = s.length();
        int p[][] = new int[l][l]; // store number of character change to let the substring from beg to end be the palindrome
        int dp[][] = new int[l][k + 1]; // store the result
        for (int i = 0; i < l; i++){
            Arrays.fill(dp[i], 999999);
        }
        for (int end = 0; end < l; end++){
            for (int beg = 0; beg <= end; beg++){
                if (beg == end){
                    p[beg][end] = 0;
                }
                else if (end == beg + 1){
                    p[beg][end] = (s.charAt(beg) == s.charAt(end) ? 0 : 1);
                }
                else if (s.charAt(beg) == s.charAt(end)){
                    p[beg][end] = p[beg + 1][end - 1];
                }
                else{
                    p[beg][end] = p[beg + 1][end - 1] + 1;
                }
            }

        }
        for (int beg = 0; beg < l; beg++){
            dp[beg][1] = p[beg][l - 1];
        }
        for (int beg = l - 1; beg >= 0; beg--){
            for (int slides = 2; slides <= k; slides++){
                for (int next = beg; next < l - 1; next++){
                    int update = p[beg][next] + dp[next + 1][slides - 1];
                    dp[beg][slides] = Math.min(dp[beg][slides], update);
                }
            }
        }
        return dp[0][k];
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 4;
        System.out.println(palindromePartition(s, k));
    }
}
