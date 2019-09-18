package Dynamic_Programming;

import java.util.HashMap;
import java.util.Scanner;

public class PrimeDigits {
    public static int MOD = 1000000007;
    public static boolean isPrime(int n){
        if (n == 2 || n == 3 || n == 5 ||
            n == 7 || n == 11 || n == 13 ||
            n == 17 || n == 19 || n == 23 ||
            n == 29 || n == 31 || n == 37 ||
            n == 41 || n == 43){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        int dp[] = new int[400001];
        dp[0] = dp[1] = dp[2] = dp[3] = dp[4] = 0;
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j <= 9; j++){
                for (int k = 0; k <= 9; k++){
                    for (int l = 0; l <= 9; l++) {
                        if (isPrime(i + j + k) &&
                            isPrime(j + k + l) &&
                            isPrime(i + j + k + l)){
                            hm.put(i + "" + j + "" + k + "" + l, 0);
                        }
                    }
                }
            }
        }
        System.out.println(hm.keySet());
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
