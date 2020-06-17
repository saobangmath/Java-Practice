package Graphs;


import java.io.*;
import java.util.StringTokenizer;

/**
 * Blessed are those who suffer for doing what is right.
 * The kingdom of heaven belongs to them.
 * (Matthew 5:10-12)
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class PhoenixAndBerries {
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
            int k = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = in.nextInt();
                b[i] = in.nextInt();
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