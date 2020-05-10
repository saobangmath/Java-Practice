package Graphs;
import java.util.*;
import java.io.*;

public class SortingVases {
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
        static int[] p = new int[20];
        static int[][] cost = new int[20][20];
        static int[] a =  new int[20];
        static boolean[] mark = new boolean[20];
        public void solve(InputReader in, PrintWriter out) {
            int test = Integer.parseInt(in.nextToken());
            for (int i = 0; i < test; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int j, k;
                for (j = 1; j <= n; j++){
                    mark[j] = false;
                    a[j] = j;
                    for (k = 1; k <= n; k++){
                        cost[i][j] = 0;
                    }
                }
                // read current position
                for (j = 1; j <= n; j++){
                    p[j] = in.nextInt();
                }
                // read the cost for each pair of points
                for (j = 0; j < m; j++){
                    int x = in.nextInt();
                    int y = in.nextInt();
                    cost[x][y] = 0;
                }
                int cnt = 0;
                for (int src = 1; src <= n; src++){
                    if (!mark[src]){
                        cnt += dfs(src);
                    }
                }
                out.println(cnt);
            }
        }

        private int dfs(int src) {
            int pos = a[p[src]];
            int cnt = 0;
            while (pos != src){
                cnt++;
                pos = a[p[pos]];
            }
            return cnt - 1;
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
