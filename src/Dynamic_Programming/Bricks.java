package Dynamic_Programming;

import java.util.Scanner;

public class Bricks {
    static int MOD = 998244353;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n bricks
        int m = sc.nextInt(); // m colors
        int k = sc.nextInt(); // k bricks
        int brick, color;
        long dp[][] = new long[n + 1][k + 1];
        for (brick = 1; brick <= n; brick++){
            dp[brick][0] = m;
        }
        for (brick = 2; brick <= n; brick++){
            for (color = 1; color <= k; color++){
                dp[brick][color] = (dp[brick - 1][color] + (m - 1) * dp[brick - 1][color - 1]) % MOD;
            }
        }
        System.out.println(dp[n][k]);
    }
}
