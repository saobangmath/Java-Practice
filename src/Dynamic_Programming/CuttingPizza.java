package Dynamic_Programming;

public class CuttingPizza {
    public static void main(String[] args) {
        String[] pizza = {"A..","AAA","..."};
        int k = 3;
        assert(ways(pizza, k) == 3);
    }
    static int MOD = 1000000007;
    public static  int ways(String[] pizza, int k) {
        int row = pizza.length;
        int col = pizza[0].length();
        // total sum from [i, j] -> [k, l];
        int[][][][] total = new int[row + 1][col + 1][row + 1][col + 1];
        int[][][] dp = new int[row + 1][col + 1][k + 1];
        int i, j, x, y, m, n;
        // total from start to end;
        for (i = 0; i < row; i++){
            for (j = 0; j < col; j++){
                for (x = 0; x <= i; x++){
                    for (y = 0; y <= j; y++){
                        total[0][0][i][j] += (pizza[x].charAt(y) == 'A' ? 1 : 0);
                    }
                }
            }
        }
        // total from initial square(i, j) to square(x, y);
        for (i = 0; i < row; i++){
            for (j = 0; j < col; j++){
                for (x = 0; x <= i; x++){
                    for (y = 0; y <= j; y++){
                        if (x >= 1 && y >= 1){
                        total[x][y][i][j] =   total[0][0][i][j]
                                            - total[0][0][x - 1][j]
                                            - total[0][0][i][y - 1]
                                            + total[0][0][x - 1][y - 1];
                        }
                        else  if (x >= 1){
                            total[x][y][i][j] = total[0][0][i][j] - total[0][0][x - 1][j];
                        }
                        else if (y >= 1){
                            total[x][y][i][j] = total[0][0][i][j] - total[0][0][i][y - 1];
                        }
                    }
                }
            }
        }
        return dfs(0, 0, row, col, total, dp, k);
    }

    private static int dfs(int i, int j, int row, int col, int[][][][] total, int[][][] dp, int k) {
        if (k == 0){
            if (total[i][j][row - 1][col - 1] > 0){
                dp[i][j][k] = 1;
            }
            else{
                dp[i][j][k] = 0;
            }
        }
        else{
            for (int row_cut = i; row_cut < row - 1; row_cut++){
                dp[i][j][k] += dfs(row_cut + 1, j, row, col, total, dp, k - 1);
                dp[i][j][k]  %= MOD;
            }
            for (int col_cut = j; col_cut < col - 1; col_cut++){
                dp[i][j][k] += dfs(i, col_cut + 1, row, col, total, dp, k - 1);
                dp[i][j][k] %= MOD;
            }
        }
        return dp[i][j][k];
    }
}
