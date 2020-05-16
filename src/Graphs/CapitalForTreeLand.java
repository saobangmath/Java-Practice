package Graphs;
import java.util.*;
import java.io.*;

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
            ArrayList<Integer> E[] = new ArrayList[n];
            int[] dp = new int[n];
            boolean mark[] = new boolean[n];
            for (i = 0; i < n; i++){
                E[i] = new ArrayList<>();
            }
            for (i = 0; i < n - 1; i++){
                x = in.nextInt() - 1;
                y = in.nextInt() - 1;
                E[x].add(y);
            }
            for (i = 0; i < n; i++){
                if (!mark[i]){
                    dfs(i, E, mark, dp);
                }
            }
            for (i = 0; i < n; i++){
                out.print(dp[i] + " ");
            }
        }

        private int dfs(int src, ArrayList<Integer>[] E, boolean[] mark, int[] dp) {
            if (mark[src]){
                return dp[src];
            }
            else{
                mark[src] = true;
                for (int dest : E[src]){
                    dp[dest]++;
                    dp[src] += (dfs(dest, E, mark, dp) - 1);
                }
                return dp[src];
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
