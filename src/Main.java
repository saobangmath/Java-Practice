import Implementations.ArrayConstruction;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }
    // main solver

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int i, j;
            int[] cnt = new int[n];
            boolean[] mark = new boolean[n];
            ArrayList<Integer> E[] = new ArrayList[n];
            for (i = 0; i < n; i++){
                E[i] = new ArrayList<>();
            }
            for (i = 0; i < n - 1; i++){
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                E[x].add(y);
            }
            for (int src = 0; src < n; src++){
                dfs(src, E, cnt, mark);
            }
            Arrays.sort(cnt);
            for (i = 0; i < n; i++){
                out.print(cnt[i] + " ");
            }
        }

        private void dfs(int src, ArrayList<Integer>[] E, int[] cnt, boolean[] mark) { // after this step, the cnt[src] is the total indirect roads;

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