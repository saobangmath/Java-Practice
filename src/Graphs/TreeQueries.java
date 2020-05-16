package Graphs;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * Problem E div 3 contest #629
 * Nice ideas from editorial: maintain a tin[j], tout[j] array which is the first time and last time an edge enter node j;
 * This is done by running dfs through the root;
 * There is an important note:
 * - Node u is the parent of v if tin(u) <= tin(v) && tout(u) >= tout(v).
 * - The condition above is the necessary and complete condition;
 */
public class TreeQueries {
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
        static int depth[] = new int[200000];
        static int tin[] = new int[200000];
        static int tout[] = new int[200000];
        static int T = 0;
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> E[] = new ArrayList[n];
            int par[] = new int[n];
            boolean mark[] = new boolean[n];
            int i, j, x, y;
            for (i = 0; i < n; i++) {
                E[i] = new ArrayList<>();
                par[i] = -1;
            }
            par[0] = 0;
            for (i = 0; i < n - 1; i++) {
                x = in.nextInt() - 1;
                y = in.nextInt() - 1;
                E[x].add(y);
                E[y].add(x);
            }
            // create parent array;
            dfs(0, E, par, mark, 0);
            while (m > 0) {
                int q = in.nextInt();
                int max = -1;
                int root = 0;
                int target = -1;
                Set<Integer> set = new HashSet<>();
                for (j = 0; j < q; j++) {
                    int parent = par[in.nextInt() - 1];
                    if (parent != 0){
                        if (depth[parent] > max){
                            max = depth[parent];
                            target = parent;
                        }
                        set.add(parent);
                    }
                }
                boolean ok = true;
                for (int e : set){
                    if (tin[e] > tin[target] || tout[e] < tout[target]){
                        ok = false;
                        break;
                    }
                }
                if (ok) out.println("YES");
                else out.println("NO");
                m--;
            }
        }
        private void dfs(int src, ArrayList<Integer>[] E, int[] par, boolean[] mark, int d) {
            mark[src] = true;
            depth[src] = d;
            tin[src] = T++;
            for (int dest : E[src]){
                if (!mark[dest]){
                    par[dest] = src;
                    dfs(dest, E, par, mark, d + 1);
                }
            }
            tout[src] = T++;
        }
        // custom comparable to sort the vertices by their depth;
        static class CustomComparable implements Comparator<Integer>{

            @Override
            public int compare(Integer o1, Integer o2) {
                if (depth[o1] > depth[o2]){
                    return -1;
                }
                else if (depth[o1] < depth[o2]){
                    return 1;
                }
                else{
                    return 0;
                }
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
