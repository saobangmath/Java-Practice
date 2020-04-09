package BigInteger;

import java.util.Scanner;
// solve the equation: n * a ^ n congruence b mod p and n <= x;
// d1 = n mod (p - 1); d2 = n mod p
// d2 * a ^ d1 congruence b mod p
// by Chinese remainder, one root is: d2 + p * (d1 + p - 1 - d2)
public class CongruenceEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long p = sc.nextLong();
        long x = sc.nextLong();

        System.out.println(solve(a, b, p, x));
    }

    private static long solve(long a, long b, long p, long x) {
        long result = 0;
        long mod = p * (p - 1);
        long cur = 1; // a ^ d1 mod
        for (long d1 = 0; d1 < p - 1; d1++){
            long d2 = (b * Modinverse(cur, p)) % p;
            long t = (d2 + p * (d1 + p - 1 - d2)) % (mod);
            if (t <= x){
                result += ((x - t) / mod + 1);
            }
            cur = (cur * a) % p;
        }
        return result;
    }
    // calculate a^-1 mod m;
    private static long Modinverse(long a, long m){
        long m0 = m;
        long y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1)
        {
            // q is quotient
            long q = a / m;

            long t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }
}
