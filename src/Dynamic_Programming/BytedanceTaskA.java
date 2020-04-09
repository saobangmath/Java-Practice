package Dynamic_Programming;

public class BytedanceTaskA {
    public static int computePopulation(int n) {
        int[] dp = new int[n + 1];
        int r = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int d = 5; d <= 8; d++){
                if (i >= d){
                    dp[i] += dp[i - d];
                }
                else{
                    break;
                }
            }
            r += dp[i];
        }
        return r;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(computePopulation(n));
    }
}
