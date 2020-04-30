package Implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arrangement implements Runnable {
    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];
        int i, j;
        for (i = 0; i <= 30; i++){
            dp[0][i] = 1;
        }
        for (i = 1; i <= 30; i++){
            for (j = 1; j <= i; j++){
                dp[j][i] = dp[j - 1][i - 1] + dp[j][i - 1];
            }
        }
        try {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            int t = Integer.parseInt(in[2]);

            if (m < 1 || n < Math.min(4, t - 1) || t < 5){
                System.out.println(0);
                return;
            }
            int u = Math.min(t - 4, m);
            long res = 0;
            for (int girls = Math.max(1, t - n); girls <= u; girls++){
                int boys = t - girls;
                if (boys < 4){
                    break;
                }
                res += dp[boys][n] * dp[girls][m];
            }System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Arrangement().run();
    }
}