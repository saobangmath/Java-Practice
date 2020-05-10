package Graphs;
import java.util.*;
import java.io.*;
public class QuantifierQuestion
{
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
            int m = in.nextInt();
            ArrayList<Integer>[] E = new ArrayList[n];
            int clone1[] = new int[n];
            int clone2[] = new int[n];
            int color [] = new int[n];
            int i, x, y;
            int cnt = 0;
            for (i = 0; i < n; i++){
                E[i] = new ArrayList<>();
                color[i] = -1; clone1[i] = -1; clone2[i] = -1;
            }
            for (i = 0; i < m; i++){
                x = in.nextInt() - 1;
                y = in.nextInt() - 1;
                E[x].add(y);
            }
            for (i = 0; i < n; i++){
                if (color[i] == -1){
                    int au1 = dfs1(i, clone1, E);
                    int au2 = dfs2(i, clone2, E);
                    if (au1 == -1){
                        out.println(-1);
                        return;
                    }
                    if (au1 > au2){
                        cnt += au1;
                        dfs1(i, color, E);
                    }
                    else{
                        cnt += au2;
                        dfs2(i, color, E);
                    }
                }
            }
            out.println(cnt);
            for (i = 0; i < n; i++){
                char op = (color[i] == 1 ? 'A' : 'E');
                out.print(op);
            }
        }
        // this dfs function is when the src is assigned to a universal operator;
        private int dfs1(int src, int[] color, ArrayList<Integer>[] E) {
            int cnt = 1;
            color[src] = 1;
            for (int dest : E[src]){
                if (src == 16){
                    System.out.print(dest + " ");
                }
                if (color[dest] == 1){
                    return -1;
                }
                else if(color[dest] == -1){
                    int au = dfs2(dest, color, E);
                    if (au == -1){
                        return -1;
                    }
                    else{
                        cnt += au;
                    }
                }
            }
            return cnt;
        }
        private int dfs2(int src, int[] color, ArrayList<Integer>[] E){
            color[src] = 0;
            int cnt = 0;
            for (int dest : E[src]){
                if (color[dest] == 0){
                    return -1;
                }
                else if (color[dest] == -1){
                    int au = dfs1(dest, color, E);
                    if (au == -1){
                        return -1;
                    }
                    else{
                        cnt += au;
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
