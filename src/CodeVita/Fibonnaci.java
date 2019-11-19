package CodeVita;

public class Fibonnaci {
    static final int[][] M = {{1, 1},{1, 0}};

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Fib(5));
    }
    static int Fib(int n){
        int[][] F = {{1, 1}, {1, 0}};
        if (n == 0){
            return 0;
        }
        power(F, n - 1);
        return F[0][0];
    }

    private static void power(int[][] F, int n) {
        if (n <= 1){
            return;
        }
        power(F, n / 2);
        mutiply(F, F);
        if (n % 2 != 0){
            mutiply(F, M);
        }
    }

    private static void mutiply(int[][] F, int[][] M){
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int t = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = t;
    }
}
