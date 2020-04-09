package BigInteger;

import java.util.Scanner;

public class FootballSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = sc.nextLong();
        long w = sc.nextLong();
        long d = sc.nextLong();
        solve(n, p, w, d);
    }
    private static long gcd(long a, long b){
        if (a == 0){
            return b;
        }
        else{
            return (a > b) ? gcd(b, a) : gcd(a, b % a);
        }
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
    private static void solve(long n, long p, long w, long d) {
        long gcd = gcd(w, d);
        if (p == 0){
            System.out.println(0 + " " + 0 + " " + n);
            return;
        }
        if (p % gcd != 0){
            System.out.println(-1);
            return;
        }
        if (w * n < p){
            System.out.println(-1);
            return;
        }
        else{
            w = w / gcd;
            d = d / gcd;
            p = p / gcd;
            long y = ((p % w) * Modinverse(d, w)) % w;
            long x = (p - y * d) / w;
            long z = (n - x - y);
            if (x >= 0 && y >=0 && z >=0 ){
                System.out.println(x +" " + y + " " + z);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
