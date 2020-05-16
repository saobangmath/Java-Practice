package Implementations;
import java.util.*;
import java.io.*;

public class ArrayConstruction {
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
        static int[] a = new int[200001];
        public void solve(InputReader in, PrintWriter out) {
            int test = Integer.parseInt(in.nextToken());
            for (int i = 0; i < test; i++) {
                int n = in.nextInt();
                PriorityQueue<Pair> pq = new PriorityQueue<>();
                pq.offer(new Pair(1, n));
                int cur = 1;
                while (!pq.isEmpty()){
                    Pair top = pq.poll();
                    int pos = (top.r + top.l) / 2;
                    a[pos] = cur++;
                    if (pos > top.l){
                        pq.offer(new Pair(top.l, pos - 1));
                    }
                    if (pos < top.r){
                        pq.offer(new Pair(pos + 1, top.r));
                    }
                }
                for (int j = 1; j <= n; j++){
                    out.print(a[j] + " ");
                }
                out.println();
            }
        }
    }
    static class Pair implements Comparable<Pair>{
        public int l,r;
        public  Pair(int l, int r){
            this.r = r; this.l = l;
        }

        @Override
        public int compareTo(Pair o) {
            int d1 = this.r - this.l;
            int d2 = o.r - o.l;
            if(d1 > d2){
                return -1;
            }
            else if (d2 > d1){
                return 1;
            }
            else{
                if (this.l > o.l){
                    return 1;
                }
                else{
                    return -1;
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
