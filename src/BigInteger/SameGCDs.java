package BigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class SameGCDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++){
            long a = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(solve(a, m));
        }
    }

    private static String solve(long a, long m) {
        long gcd = gcd(a, m);
        return EulerFunction(m / gcd);
    }
    private static String EulerFunction(long n){
        BigInteger r = new BigInteger(n + "");
        long sqrt = (long)Math.sqrt(n);
        for (long d = 2; d <= sqrt; d++){
            if (n % d == 0){
                r = r.multiply(new BigInteger((d - 1) + "")).divide(new BigInteger(d + ""));
                while (n % d == 0){
                    n = n / d;
                }
            }
        }
        if (n > 1){
            r = r.multiply(new BigInteger((n - 1) + "")).divide(new BigInteger(n + ""));
        }
        return r.toString();
    }
    private static long gcd(long a, long b){
        if (a == 0){
            return b;
        }
        if (a > b){
            return gcd(b, a);
        }
        else{
            return gcd(a, b % a);
        }
    }
}
