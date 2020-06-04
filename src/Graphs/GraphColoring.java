package Graphs;


import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class GraphColoring {
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
        int N = 5001;
        int color[] = new int[N];
        ArrayList<Integer> E[] = new ArrayList[N];
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> sec = new ArrayList<>();
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int n3 = in.nextInt();
            for (int i = 0; i < n; i++){
                E[i] = new ArrayList<>();
                color[i] = -1;
            }
            for (int i = 0; i < m; i++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                E[u].add(v); E[v].add(u);
            }
            boolean ok = true;
            for (int src = 0; src < n; src++){
                if (color[src] == -1){
                    if (!dfs(src, 0)){
                        ok = false; break;
                    }
                }
            }
            if (!ok){
                out.println("NO");
            }
            else{
                if (sec.size() == n2 && first.size() == n1 + n3){
                    out.println("YES");
                    for (int e : sec){
                        color[e] = 2;
                    }
                    for (int i = 0; i < n1; i++){
                        color[first.get(i)] = 1;
                    }
                    for (int i = n1; i < n1 + n3; i++){
                        color[first.get(i)] = 3;
                    }
                    for (int i = 0; i < n; i++){
                        out.print(color[i]);
                    }
                }
                else if (sec.size() == n1 + n3 && first.size() == n2){
                    out.println("YES");
                    for (int e : first){
                        color[e] = 2;
                    }
                    for (int i = 0; i < n1; i++){
                        color[sec.get(i)] = 1;
                    }
                    for (int i = n1; i < n1 + n3; i++){
                        color[sec.get(i)] = 3;
                    }
                    for (int i = 0; i < n; i++){
                        out.print(color[i]);
                    }
                }
                else{
                    out.println("NO");
                }
            }
        }

        private boolean dfs(int src, int group) {
            color[src] = group;
            if (group == 0){
                first.add(src);
            }
            else{
                sec.add(src);
            }
            for (int dest : E[src]){
                if (color[dest] == group){
                    return false;
                }
                else if (color[dest] == -1){
                    dfs(dest, 1 - group);
                }
            }
            return true;
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