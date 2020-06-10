package Graphs;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * @Link:https://codeforces.com/contest/219/problem/D
 * @Key: - Let dp[u] is the number of reverted edge if u is chosen as capital if there is a direct edge from u -> v: dp[v] = dp[u] + 1;
 *       - Then, calculating dp[0] first, then using one more dfs to calculate dp[i] of all other city;
 */
public class CapitalForTreeLand {
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
            int n = in.nextInt();
            int i, x, y;
            ArrayList<Integer> in_edge[] = new ArrayList[n];
            ArrayList<Integer> out_edge[] = new ArrayList[n];
            int[] dp = new int[n];
            boolean mark[] = new boolean[n];
            for (i = 0; i < n; i++){
                in_edge[i] = new ArrayList<>();
                out_edge[i] = new ArrayList<>();
            }
            for (i = 0; i < n - 1; i++){
                x = in.nextInt() - 1;
                y = in.nextInt() - 1;
                in_edge[y].add(x);
                out_edge[x].add(y);
            }
            // calculate the dp[0] value;
            dp[0] = dfs(0, in_edge, out_edge, mark);
            Arrays.fill(mark,false);
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            mark[0] = true;
            while (!q.isEmpty()){
                int top = q.poll();
                for (int dest : in_edge[top]){
                    if (!mark[dest]){
                        dp[dest] = dp[top] - 1;
                        mark[dest] = true;
                        q.offer(dest);
                    }
                }
                for (int dest : out_edge[top]){
                    if (!mark[dest]){
                        dp[dest] = dp[top] + 1;
                        mark[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            int minimum = Integer.MAX_VALUE;
            for (i = 0; i < n; i++){
                if (dp[i] < minimum){
                    minimum = dp[i];
                    result.clear();
                    result.add(i + 1);
                }
                else if (dp[i] == minimum){
                    result.add(i + 1);
                }
            }
            out.println(minimum);
            for (int u : result){
                out.print(u + " ");
            }
        }

        private int dfs(int src, ArrayList<Integer>[] in_edge, ArrayList<Integer>[] out_edge, boolean[] mark) {
            mark[src] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            int cnt = 0;
            while (!q.isEmpty()){
                int top = q.poll();
                for (int dest : in_edge[top]){
                    if (!mark[dest]) {
                        cnt++;
                        q.add(dest);
                        mark[dest] = true;
                    }
                }
                for (int dest : out_edge[top]){
                    if (!mark[dest]){
                        q.add(dest);
                        mark[dest] = true;
                    }
                }
            }
            return cnt;
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
