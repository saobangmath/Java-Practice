package Dynamic_Programming;

import java.util.Scanner;

public class LongestCommonString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(commonChild(s1, s2));
    }

    static int commonChild(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++){
            for (int j = 1; j <= l2; j++){
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                dp[i][j] = (ch1 == ch2)? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[l1][l2];
    }
}