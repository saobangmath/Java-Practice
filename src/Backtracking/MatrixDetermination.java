package Backtracking;

public class MatrixDetermination {
    public static void getCofactor(int[][] mat, int[][] temp, int p, int q, int n){
        int i = 0, j = 0;
        int row, col;
        for (row = 0; row < n; row++){
            for (col = 0; col < n; col++){
                if (row != p && col != q){
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1){
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    static long determinantOfMatrix(int[][] mat, int n){
        long D = 0;
        if (n == 1){
            return (long)mat[0][0];
        }
        else{
            int temp[][] = new int[n][n];
            int sign = 1;
            for (int f = 0; f < n; f++){
                // getting cofactor of mat[0][f];
                getCofactor(mat, temp, 0, f, n);
                D = (D +  (sign * mat[0][f] * determinantOfMatrix(temp, n - 1)));
                sign = -sign;
            }
            return D;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] respectList =  {{0,1},{1,2},{2,3},{3,0},{1,3}};
        assert (determinantOfMatrix(respectList, n) == 32);
    }
}
