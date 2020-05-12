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
        static int[] a =  new int[20];
        static boolean[] mark = new boolean[20];
        public void solve(InputReader in, PrintWriter out) {
            int test = in.nextInt();
            for (int i = 0; i < test; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int j;
                ArrayList<Integer>[] E = new ArrayList[n + 1];
                for (j = 1; j <= n; j++){
                    mark[j] = false;
                    a[j] = j;
                }
                // read current position;
                for (j = 1; j <= n; j++){
                    p[j] = in.nextInt();
                    E[j] = new ArrayList<>();
                }
                 // graph maker;
                for (j = 0; j < m; j++){
                    int x = in.nextInt();
                    int y = in.nextInt();
                    E[x].add(y); E[y].add(x);
                }
                int cnt = 0;
                for (int src = 1; src <= n; src++){
                    if (!mark[src]){
                        cnt += dfs(src, mark, E);
                    }
                }
                out.println(cnt);
            }
        }

        private int dfs(int src, boolean[] mark, ArrayList<Integer>E[]) {
            int pos = a[p[src]];
            mark[p[src]] = true;
            int cnt = 0;
            while (pos != src){
                int x = pos;
                int y = a[p[pos]];
                if (!isReachable(x, y, E)){
                   cnt++;
                }
                pos = a[p[pos]];
                mark[pos] = true;
            }
            mark[src] = true;
            return cnt;
        }

        private boolean isReachable(int x, int y, ArrayList<Integer>[] E) {
            Queue<Integer> q = new LinkedList<>();
            boolean mark[] = new boolean[E.length];
            q.add(x);
            while (!q.isEmpty()){
                int top = q.poll();
                mark[top] = true;
                if (top == y){
                    return true;
                }
                else{
                    for (int dest : E[top]){
                        if (!mark[dest]){
                            mark[dest] = true;
                            q.add(dest);
                        }
                    }
                }
            }
            return false;
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
