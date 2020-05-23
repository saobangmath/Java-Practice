package Dynamic_Programming;

public class MaximumNonAdjacent {
    public static void main(String[] args) {
        int[][] matrix = {{5,4,9},{4,5,1},{3,4,10},{4,-5,1}};
        assert (maximumNonAdjacentCellsSum(matrix) == 33);
    }
    static int maximumNonAdjacentCellsSum(int[][] matrix){
        int w = matrix[0].length;
        int[] states = {0, 1, 2, 4, 5, 8, 9, 10};
        int[][] dp = new int[w + 1][16];
        int result = 0;
        for (int y = 1; y <= w; y++){
            for (int state : states){
                int au = 0;
                for (int prev : states){
                    if ((state & prev) == 0){ // not adjacent to the previous column;
                        au = Math.max(au, dp[y - 1][prev]);
                    }
                }
                dp[y][state] = au + eval(matrix, state, y);
            }
        }
        for (int state : states){
            result = Math.max(result, dp[w][state]);
        }
        return result;
    }

    private static int eval(int[][] matrix, int state, int y) {
        int result = 0;
        for (int i = 3; i >= 0; i--){
            int d = state % 2;
            if (d == 1){
                result += matrix[i][y - 1];
            }
            state = state >> 1;
        }
        return result;
    }
}
