package Dynamic_Programming;

public class booleanParentherization {
    static int MOD = 1003;

    public static void main(String[] args) {
        String expr = "T&T|F^F";
        assert (booleanParentherization(expr) == 5);
    }
    static int booleanParentherization(String expr){
        int l = expr.length();
        int i, j, k;
        int[][] T = new int[l][l];
        int[][] F = new int[l][l];
        for (i = 0; i < l; i += 2){
            char c1 = expr.charAt(i);
            if (c1 == 'T'){
                T[i][i] = 1;
            }
            else if (c1 == 'F'){
                F[i][i] = 1;
            }
            for (j = i; j >= 0; j -= 2){
                for (k = j + 1; k < i; k += 2){
                    char c2 = expr.charAt(k);
                    int t_l = T[j][k - 1];
                    int f_l = F[j][k - 1];
                    int t_r = T[k + 1][i];
                    int f_r = F[k + 1][i];
                    int total = (f_l + t_l) * (f_r + t_r);
                    int sum = 0;
                    switch (c2){
                        case '|':
                            sum = (f_l * f_r) % MOD;
                            break;
                        case '&':
                            sum = (total - t_r * t_l) % MOD;
                            break;
                        case '^':
                            sum = (t_l * t_r + f_l * f_r) % MOD;
                            break;
                    }
                    F[j][i] = (F[j][i] + sum) % MOD;
                    T[j][i] = (T[j][i] + total - sum) % MOD;
                }
            }
        }
        return T[0][l - 1];
    }
}
