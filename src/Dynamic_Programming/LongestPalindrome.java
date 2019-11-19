package Dynamic_Programming;

import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.next();
        System.out.println();
    }
    public int longestPalindromeSubseq(String s){
        int l = s.length();
        if (l == 0) return 0;
        int dp[][] = new int[l][l];
        int r  = 1;
        for (int end = 0; end < l; end++){
            for (int beg = end; beg >= 0; beg -- ){
                if (beg == end) dp[beg][end] = 1;
                else{
                    if(s.charAt(beg) == s.charAt(end)){
                        dp[beg][end] = 2 + dp[beg + 1][end - 1];
                    }
                    else{
                        dp[beg][end] = Math.max(dp[beg][end - 1], dp[beg + 1][end]);
                    }
                }
                r = Math.max(r, dp[beg][end]);
            }
        }
        return r;
    }
}
