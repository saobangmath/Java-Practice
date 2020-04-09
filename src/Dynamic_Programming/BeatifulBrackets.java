package Dynamic_Programming;

import java.util.Scanner;

public class BeatifulBrackets {
    static long MOD =  998244353;

    public static long pow(int x, int y){
        if (y == 0){
            return 1L;
        }
        else{
            long au = pow(x, y / 2);
            return ((au * au) % MOD * ((y % 2 == 0) ? 1 : x)) % MOD;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

        int l = in.length();
        int i, j;

        long[][] dp = new long[l][l];
        int count[] = new int[l];

        count[0] = (in.charAt(0) == '?') ? 1 : 0;

        for (i = 1; i < l; i++){
            count[i] = (count[i - 1] + (in.charAt(i) == '?' ? 1 : 0));
        }

        for (i = 1; i < l; i++){
            for (j = i - 1; j >= 0; j--){
                char c1 = in.charAt(j);
                char c2 = in.charAt(i);
                long x = (pow(2, count[i - 1] - count[j]) + dp[j + 1][i - 1]) % MOD;
                if (c2 == '('){
                    dp[j][i] = dp[j][i - 1];
                }
                else if (c1 == ')'){
                    dp[j][i] = dp[j + 1][i];
                }
                else if (c1 == '(' && c2 == ')'){
                    dp[j][i] = x;
                }
                else if (c1 == '?' && c2 == ')'){
                    dp[j][i] = (x + dp[j + 1][i]) % MOD;
                }
                else if (c1 == '(' && c2 == '?'){
                    dp[j][i] = (x + dp[j][i - 1]) % MOD;
                }
                else if (c1 == '?' && c2 == '?') {
                    dp[j][i] = (dp[j + 1][i] + dp[j][i - 1]+ x + dp[j + 1][i - 1]) % MOD;
                }
            }
        }
        System.out.println(dp[0][l - 1]);
    }
}
