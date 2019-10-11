package Dynamic_Programming;

public class SumDividedByFive {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(countNumbersDivisibleByFive(arr));
    }
    public static int countNumbersDivisibleByFive(int[] arr)
    {
        int l  = arr.length;
        int[] r = new int[5];
        int[][] dp = new int[l + 1][5];
        for (int i = 1; i < l + 1; i++){
            for (int j = 0; j < 5; j++){
                dp[i][j] += dp[i - 1][j];
                dp[i][(arr[i - 1] % 5)]++;
                for (int k = 0; k < 5; k++){
                    dp[i][(j + arr[i - 1]) % 5] += dp[i][j];
                }
            }
        }
        return dp[l][0];
    }
}
