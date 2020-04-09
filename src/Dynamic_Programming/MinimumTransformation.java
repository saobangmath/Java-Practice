package Dynamic_Programming;

public class MinimumTransformation {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i2 = 1; i2 <= l2; i2++){
            dp[0][i2] = i2;
        }
        for (int i1 = 1; i1 <= l1; i1++){
            dp[i1][0] = i1;
        }
        for (int i2 = 1; i2 <= l2; i2++){
            char c2 = word2.charAt(i2 - 1);
            for (int i1 = 1; i1 <= l1; i1++){
                char c1 =  word1.charAt(i1 - 1);
                if (c1 == c2){
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                }
                else{
                    dp[i1][i2]= Math.min(dp[i1 - 1][i2 - 1] + 1, dp[i1 - 1][i2]);
                }
            }
        }
        return dp[l1][l2];
    }
}
