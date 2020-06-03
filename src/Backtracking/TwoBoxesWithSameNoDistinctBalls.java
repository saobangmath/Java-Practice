package Backtracking;

public class TwoBoxesWithSameNoDistinctBalls {
    static int cnt = 0;
    static int total = 0;
    public static double getProbability(int[] balls) {
        int n = balls.length;
        int d[] = new int[n];
        dfs(0, d, balls);
        //System.out.println(cnt + " " + total);
        return (double)(cnt) / total;
    }
    public static void dfs(int i, int[] d, int[] balls){
        int n = d.length;
        if (i == n){
            int sum = 0;
            int diff = 0;
            for (int j = 0; j < n; j++){
                sum += d[j];
                if (d[j] == -balls[j]) diff--;
                else if (d[j] == balls[j]) diff++;
            }
            if (sum == 0){
                int au = 0;
                total += au;
                if (diff == 0) cnt++;
            }
        }
        else{
            for (int set = -balls[i]; set <= balls[i]; set += 2){
                d[i] = set;
                dfs(i + 1, d, balls);
                //d[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] balls = new int[]{2, 1 ,1};
         assert(getProbability(balls) == 0.6666);
    }
}
