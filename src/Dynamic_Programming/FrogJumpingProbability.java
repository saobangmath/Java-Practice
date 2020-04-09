package Dynamic_Programming;

import java.util.ArrayList;

public class FrogJumpingProbability {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int t = 20;
        int target = 6;
//        int n = 3;
//        int[][] edges = {{1,2},{1,3},{2,3}};
//        int t = 3;
//        int target = 2;
        System.out.println(frogPosition(n, edges, t, target));
    }
    public static double frogPosition(int n, int[][] edges, int t, int target) {
        double[][] dp = new double[t + 1][n];
        boolean[] mark = new boolean[n];
        ArrayList<Integer>[] E = new ArrayList[n];
        for (int i = 0; i < n; i++){
            E[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            E[edge[0] - 1].add(edge[1] - 1);
            E[edge[1] - 1].add(edge[0] - 1);
        }
        target--;
        dp[0][0] = 1;
        dfs(0, E, mark, dp, 0, t);
        for (int i = 0; i <= t; i++){
            for (int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[t][target];
    }
    public static void dfs(int src, ArrayList<Integer>[] E, boolean mark[], double[][] dp, int step, int t){
        if (step == t){
            return;
        }
        else{
            int count = 0;
            mark[src] = true;
            for (int dest : E[src]){
                if (!mark[dest]){
                    count++;
                }
            }
            if (count == 0){ // can't go anywhere
                for (int x = step + 1; x <= t; x++){
                    dp[x][src] += dp[step][src];
                }
            }
            else{
                for (int dest : E[src]){
                    if (!mark[dest]){
                        dp[step + 1][dest] += ((double)1 / count) * dp[step][src];
                        dfs(dest, E, mark, dp, step + 1, t);
                    }
                }
            }
            mark[src] = false;
        }
    }
}
