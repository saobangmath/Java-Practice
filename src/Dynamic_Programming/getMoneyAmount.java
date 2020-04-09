package Dynamic_Programming;

public class getMoneyAmount {
    public static void main(String[] args) {
        int n = 100;
        assert (getMoney(n) == 400);
    }
    public static int getMoney(int n) {
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int high = 1; high <= n; high++){
            for (int low = 1; low < high; low++){
                if (high != low){
                    for (int pos = low; pos <= high; pos++){
                        dp[low][high][pos] = Integer.MAX_VALUE;
                        for (int choose = low; choose <= high; choose++){
                            if (choose == pos){ // founeded;
                                
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
