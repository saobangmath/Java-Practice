package Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PrimeDigits {
    static int MOD = 1000000007;
    static int N = 400000;
    static HashMap<String, Integer> hm = new HashMap<>();
    static ArrayList<String> keys = new ArrayList<>();
    static int[] dp = new int[N + 1];
    public PrimeDigits(){
        dp[1] = 10;
        dp[2] = 90;
        int three = 0, four = 0;
        for (int a = 0; a < 10; a++){
            for (int b = 0; b < 10; b++){
                for (int c = 0; c < 10; c++){
                    if (isPrime(a + b + c)){
                        if (a != 0) {
                            three++;
                        }
                        for (int d = 0; d < 10; d++){
                            if (isPrime(b + c + d) && isPrime(a + b + c + d)){
                                if (a != 0) {four++;}

                                for (int e = 0; e < 10; e++){
                                    if ( isPrime(c + d + e) && isPrime(b + c + d + e)
                                            && isPrime(a + b + c + d + e)){

                                        String key = a + "" + b  + c + d + e;
                                        hm.put(key, 1);
                                        keys.add(key);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(keys);
        dp[3] = three;
        dp[4] = four;
        for (int d = 5; d <= N; d++){
            int r = 0;
            HashMap<String, Integer> au = new HashMap<>();
            for (String key : keys){
                au.put(key, 0);
                if (key.charAt(0) != '0') {
                    r = (r + hm.get(key)) % MOD;
                }
            }
            dp[d] = r;
            for (String key : keys){
                for (int digit = 0; digit < 10; digit++){ // 10
                    try{
                        String new_key = key.substring(1, 5) + digit;
                        int add = hm.get(new_key);
                        int new_val = (au.get(key) + add) % MOD;
                        au.put(key, new_val);
                    }
                    catch(Exception e){

                    }
                }
            }

            for (String key : keys){
                hm.put(key, au.get(key));
            }
        }
    }

    public static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        int d = (int)Math.sqrt(n);
        for (int i = 2; i <= d; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        PrimeDigits sol = new PrimeDigits();
        for (int i = 0; i < q; i++){
            int n = sc.nextInt();
            System.out.println(sol.dp[n]);
        }
    }
}
