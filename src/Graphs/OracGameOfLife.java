package Graphs;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * ProbE div2 Codeforce #641;
 * Ideas: define a square with coordinates i, j is GOOD if there exists a adjacent square with the same color with it, else BAD otherwise;
 * At first, the color of grid[i][j] is x;
 * Its color will change after k iterations with k is the minimum distance between its square to a GOOD square (could possibly be itself).
 * Then the grid will be STABLE (when each color not changed anymore or the color of each grid is toggled between black and white);
 * Then each queries could be served in exactly O(1);
 *
 */
public class OracGameOfLife implements Runnable{
    public static void main(String[] args) {
        new OracGameOfLife().run();
    }

    @Override
    public void run() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task taskE = new Task();
        taskE.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{
        static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int t = in.nextInt();
            int[][] grid = new int[n][m];
            //check if the square with coordinates i,j is GOOD or bad;
            boolean[][] isgood = new boolean[n][m];
            // the min distance from the square to nearest GOOD grid;
            int[][] minDist = new int[n][m];
            // mark if a square is already traversed through;
            boolean[][] mark = new boolean[n][m];
            boolean isBad = true;
            int i, j;
            long p;
            for (i = 0; i < n; i++){
                String token = in.nextToken();
                for (j = 0; j < m; j++){
                    grid[i][j] = token.charAt(j) - '0';
                }
            }

            for (i = 0; i < n; i++){
                for (j = 0; j < m; j++){
                    for (int[] dir : dirs){
                        int new_i = i + dir[0];
                        int new_j = j + dir[1];
                        if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < m){
                            if (grid[i][j] == grid[new_i][new_j]){
                                isgood[i][j] = true;
                                isBad = false; break;
                            }
                        }
                    }
                }
            }
            if (!isBad){
                dfs(isgood, minDist, mark);
            }
            for (int time = 0; time < t; time++){
                i = in.nextInt() - 1;
                j = in.nextInt() - 1;
                p = in.nextLong();
                if (isBad){
                    out.println(grid[i][j]);
                }
                else if (p <= minDist[i][j]){
                    out.println(grid[i][j]);
                }
                else{
                    if (p % 2 == minDist[i][j] % 2) {
                        out.println(grid[i][j]);
                    } else {
                        out.println(1 ^ grid[i][j]);
                    }
                }
            }
        }

        private void dfs(boolean[][] isgood, int[][] minDist, boolean[][] mark) {
            int n = isgood.length;
            int m = isgood[0].length;
            int i, j;
            Queue<Pair> q = new LinkedList<>();
            for (i = 0; i < n; i++){
                for (j = 0; j < m; j++){
                    if (isgood[i][j]){
                        minDist[i][j] = 0;
                        mark[i][j] = true;
                        q.offer(new Pair(i, j));
                    }
                }
            }
            while (!q.isEmpty()){
                Pair top = q.poll();
                int x = top.x;
                int y = top.y;
                for(int[] dir : dirs){
                    int new_x = x + dir[0];
                    int new_y = y + dir[1];
                    if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < m
                        && !mark[new_x][new_y]){
                        minDist[new_x][new_y] = minDist[x][y] + 1;
                        mark[new_x][new_y] = true;
                        q.offer(new Pair(new_x, new_y));
                    }
                }
            }
        }
    }
    static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x = x; this.y = y;
        }
    }
    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}
