package Dynamic_Programming;

import java.util.Arrays;

public class minCut {
    public int minCut(String s) {
        int l = s.length();
        boolean[][] isPalindrome = new boolean[l][l];
        int[] dp = new int[l];
        Arrays.fill(dp, 999999);
        for (int end = 0; end < l; end++){
            isPalindrome[end][end] = true;
            for (int beg = end - 1; beg >= 0; beg--){
                if (s.charAt(end) == s.charAt(beg)){
                    if (end >= beg + 2) {
                        isPalindrome[beg][end] = isPalindrome[beg + 1][end - 1];
                    }
                    else{
                        isPalindrome[beg][end] = true;
                    }
                }
                else{
                    isPalindrome[beg][end] = false;
                }
            }
        }
        for (int end = 0; end < l; end++){
            for (int beg = end; beg >= 0; beg--){
                if (isPalindrome[beg][end]){
                    if (beg == 0){
                        dp[end] = 1;
                    }
                    else{
                        dp[end] = Math.min(dp[end],  + dp[beg - 1] + 1);
                    }
                }
            }
        }
        return dp[l - 1];
    }

    public static void main(String[] args) {

    }
}
