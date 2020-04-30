package Greedy;

import java.util.*;

public class EqualSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String in = sc.next();
        int max = longestPrefix(in, n);
        System.out.print(in.substring(0, max));
        for (int i =  0; i < k; i++){
            System.out.print(in.substring(max, n));
        }
    }

    private static int longestPrefix(String in, int l) {
        int[] dp = new int[l];
        // KMP pre-processing
        for (int i = 1; i < l; i++){
            int j = i;
            while (j > 0){
                if (in.charAt(i) == in.charAt(dp[j - 1])){
                    dp[i] = dp[j - 1] + 1;
                    break;
                }
                else{
                    j = dp[j - 1];
                }
            }
        }
        return dp[l - 1];
    }
}
