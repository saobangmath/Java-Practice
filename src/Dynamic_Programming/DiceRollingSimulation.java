package Dynamic_Programming;

import java.util.Scanner;

public class DiceRollingSimulation {
    static int MOD = 1000000007;
    public static int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][6][16];
        for (int dice = 1; dice <= 6; dice++){
            dp[1][dice - 1][1] = 1;
        }
        for (int time = 2; time <= n; time++){
            for (int dice = 1; dice <= 6; dice++){
                for (int occur = 1; occur <= 15; occur++){
                    if (occur <= rollMax[dice - 1] && time >= occur){
                        for (int d = 1; d <= 6; d++){
                            if (d != dice){
                                for (int x = 1; x <= 16; x++){
                                    dp[time][dice - 1][occur] += dp[time - occur][d - 1][x - 1];
                                    dp[time][dice - 1][occur] = dp[time][dice - 1][occur] % MOD;
                                }
                            }
                        }
                        if (time == occur) dp[time][dice - 1][occur]++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        int r = 0;
        for (int dice = 1; dice <= 6; dice++){
            for (int max = 1; max <= 16; max++){
                r = (r + dp[n][dice - 1][max - 1]) % MOD;
            }
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rollMax  = new int[6];
        for (int i = 0; i < 6; i++){
            rollMax[i] = sc.nextInt();
        }
        System.out.println(dieSimulator(n, rollMax));
    }
}
