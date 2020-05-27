package Graphs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class HydraHead {
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
        static class Pair{
            public int x, y;
            public  Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        public void solve(InputReader in, PrintWriter out) {
            boolean stop = false;
            while (!stop){
                int h = in.nextInt();
                int t = in.nextInt();
                if (h == 0 && t == 0){
                    stop = true;
                }
                else{
                    int visited[][] = new int[h + 1][t + 1];
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(h, t));
                    int cnt = 0;
                    while (!q.isEmpty()){
                        int l = q.size();
                        for (int i = 0; i < l; i++){
                            Pair top = q.poll();
                        }
                    }
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