package Dynamic_Programming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
// placing all n rocks in the chess board such that:
// - every board is under attacked (every row / column has at least 1 rocks)
// - there are exactly k pairs of rocks attacked each others.
public class PlacingRocks {
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
        static int MOD = 998244353;
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long k = in.nextLong();
            // ideas:

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