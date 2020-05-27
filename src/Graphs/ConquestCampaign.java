package Graphs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class ConquestCampaign {
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
        static int[][] dirs = new int[][] {{0, 1}, {0,-1}, {1, 0}, {-1, 0}};
        static class Pair{
            public int x, y;
            public Pair(int x, int y){
                this.x =x; this.y = y;
            }
        }
        public void solve(InputReader in, PrintWriter out) {
            int r = in.nextInt();
            int c = in.nextInt();
            int n = in.nextInt();
            boolean[][] mark = new boolean[r][c];
            int i, j;
            int cnt = 0;
            Queue<Pair> q = new LinkedList<>();
            for (i = 0; i < n; i++){
                int xi = in.nextInt() - 1;
                int yi = in.nextInt() - 1;
                if (!mark[xi][yi]){
                    cnt++;
                    mark[xi][yi] = true;
                    q.add(new Pair(xi, yi));
                }
            }
            if (cnt == r * c){
                out.println(1);
                return;
            }
            int result = 1;
            while (!q.isEmpty()) {
                int l = q.size();
                boolean hasNew = false;
                for (i = 0; i < l; i++) {
                    Pair top = q.poll();
                    for (int[] dir : dirs) {
                        int new_x = top.x + dir[0];
                        int new_y = top.y + dir[1];
                        if (Math.min(new_x, new_y) >= 0 && new_x < r
                                && new_y < c && !mark[new_x][new_y]) {
                            hasNew = true;
                            mark[new_x][new_y] = true;
                            q.add(new Pair(new_x, new_y));
                        }
                    }
                }
                if (hasNew){
                    result++;
                }
            }
            out.println(result);
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