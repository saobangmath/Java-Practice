package Dynamic_Programming;

public class countSquares {
    public static int countSquares(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int count = 0;

        int[][] dp = new int[h][w];
        dp[0][0] = matrix[0][0];

        for (int y = 1; y < h; y++) {
            dp[y][0] = dp[y - 1][0] + matrix[y][0];
        }
        for (int x = 1; x < w; x++){
            dp[0][x] = dp[0][x - 1] + matrix[0][x];
        }
        for (int y = 1; y < h; y++) {
            for (int x = 1; x < w; x++) {
                dp[y][x] = dp[y - 1][x] + dp[y][x - 1] - dp[y - 1][x - 1] + matrix[y][x];
            }
        }
        for (int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){
                int m = Math.min(x, y);
                for (int s = 1; s <= m + 1; s++){
                    if (s != m + 1){
                        int sum = dp[y][x] - (dp[y - s][x] + dp[y][x - s] - dp[y - s][x - s]);
                        if (sum == s * s){
                            ++count;
                        }
                    }
                    else if (x == y && dp[x][x] == s * s){
                        ++count;
                    }
                    else if (x > y && dp[y][x] - dp[y][x - y - 1] == s * s){
                        ++count;
                    }
                    else if (x < y && dp[y][x] - dp[y - x - 1][x] == s * s){
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},{0,1,0},{0,0,0}};
        System.out.println(countSquares(matrix));
        assert (countSquares(matrix) == 2);
    }
}
