//This is The Coding Area
import java.util.Scanner;
public class ProbD {
    static long fib(int n,int MOD)
    {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1,MOD);

        return F[0][0] % MOD;
    }

    static void multiply(long F[][], long M[][],int MOD)
    {
        long x =  (F[0][0] % MOD * M[0][0] % MOD) % MOD + (F[0][1] % MOD *M[1][0] % MOD) % MOD;
        long y =  (F[0][0] % MOD * M[0][1] % MOD) % MOD + (F[0][1] % MOD *M[1][1] % MOD) % MOD;
        long z =  (F[1][0] % MOD * M[0][0] % MOD) % MOD + (F[1][1] % MOD *M[1][0] % MOD) % MOD;
        long w =  (F[1][0] % MOD * M[0][1] % MOD) % MOD + (F[1][1] % MOD *M[1][1] % MOD) % MOD;

        F[0][0] = x % MOD;
        F[0][1] = y % MOD;
        F[1][0] = z % MOD;
        F[1][1] = w % MOD;
    }

    /* Optimized version of power() in method 4 */
    static void power(long F[][], int n, int MOD)
    {
        if( n == 0 || n == 1)
            return;
        long M[][] = new long[][]{{1,1},{1,0}};

        power(F, n/2, MOD);
        multiply(F, F, MOD);

        if (n%2 != 0)
            multiply(F, M, MOD);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long res = ((fib(N, M)) * (fib(N + 1, M))) % M ;
        System.out.println(res);
    }
}