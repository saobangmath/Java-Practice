package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBeauty {
    static int MOD = 998244353;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        long[][] min = new long[n][k + 1];
        long[][] dp = new long[n][k + 1];

        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++){
            for (int len = 2; len <= k; len++){
                min[i][len] = Integer.MAX_VALUE;
                dp[i][len] = (i > 0) ? (dp[i - 1][len]) : 0;
                for (int j = 0; j < i; j++){
                    if (len == 2 && i - j == 1){
                        min[i][len] = a[i] - a[j];
                    }
                    else if (j + 1 >= len){
                        min[i][len] = Math.min(min[i][len], Math.min(a[i] - a[j],min[j][len - 1]));
                    }
                    if (min[i][len] != Integer.MAX_VALUE){
                        dp[i][len] = (dp[i][len] + min[i][len]) % MOD;
                    }
                }
            }
        }
        System.out.println(dp[n - 1][k]);
    }
}
