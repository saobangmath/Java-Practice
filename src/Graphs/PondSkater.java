package Graphs;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @Link:https://atcoder.jp/contests/abc170/tasks/abc170_f
 * @Ideas: 1. The origin ideas of the problem is using Dijkstra algorithm to find the minimum distance between 2 vertices with each vertices represents by the x-y position of the square board and the current direction of the previous step that reached the square;
 *         2. The ideas implements in this source code is merely using the dfs with "expanding" from the destination to calculate the minimum steps to reach such directions from other point
 *         3. In such codes, such calculation is done using DP and a small optimizations when reaching another pre-visited square. If the dp value of such pre visited square is not more than the dp value of the dfs source -> BREAK; This is truly helpful in decreasing complexity of the algorithm;
 */
public class PondSkater {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{
        public void solve(InputReader in, PrintWriter out) {
            int h = in.nextInt();
            int w = in.nextInt();
            int k = in.nextInt();
            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt() - 1;
            int y2 = in.nextInt() - 1;
            char map[][] = new char[h][w];
            int[][] dp = new int[h][w];
            for (int i = 0; i < h; i++){
                map[i] = in.nextToken().toCharArray();
                for (int j = 0; j < w; j++){
                    dp[i][j] = -1;
                }
            }
            boolean[][]visited =new boolean[h][w];
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(x2, y2));
            visited[x2][y2] = true;
            dp[x2][y2] = 0;
            while (!q.isEmpty()){
                Pair top = q.poll();
                // left;
                for (int _x = top.x + 1; _x < Math.min(top.x + k + 1, h); _x++){
                    if (map[_x][top.y] != '@'){
                        if (!visited[_x][top.y]) {
                            visited[_x][top.y] = true;
                            dp[_x][top.y] = dp[top.x][top.y] + 1;
                            q.add(new Pair(_x, top.y));
                        }
                        else if (dp[_x][top.y] <= dp[top.x][top.y]){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                // right;
                for (int _x = top.x - 1; _x >= Math.max(top.x - k, 0); _x--){
                    if (map[_x][top.y] != '@'){
                        if (!visited[_x][top.y]){
                            visited[_x][top.y] = true;
                            dp[_x][top.y] = dp[top.x][top.y] + 1;
                            q.add(new Pair(_x, top.y));
                        }
                        else if (dp[_x][top.y] <= dp[top.x][top.y]){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                // up;
                for (int _y = top.y + 1; _y < Math.min(top.y + k + 1, w); _y++){
                    if (map[top.x][_y] != '@'){
                        if (!visited[top.x][_y]) {
                            visited[top.x][_y] = true;
                            dp[top.x][_y] = dp[top.x][top.y] + 1;
                            q.add(new Pair(top.x, _y));
                        }
                        else if (dp[top.x][_y] <= dp[top.x][top.y]){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
                // down;
                for (int _y = top.y - 1; _y >= Math.max(top.y - k, 0); _y--){
                    if (map[top.x][_y] != '@'){
                        if (!visited[top.x][_y]) {
                            visited[top.x][_y] = true;
                            dp[top.x][_y] = dp[top.x][top.y] + 1;
                            q.add(new Pair(top.x, _y));
                        }
                        else if (dp[top.x][_y] <= dp[top.x][top.y]){
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
            out.println(dp[x1][y1]);
        }
        static class Pair{
            public  int x, y;
            public Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
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
