package Bit_Manipulation_Techniques;

import java.io.*;
import java.util.StringTokenizer;


/**
 * @author Tran Anh Tai
 * @template for CP codes
 * Given a function F(X, Y, Z) = (X & Z) * (Y * Z);
 * find the maximum value of such function given the value of X, Y;
 * and the range of Z values [L, R];
 * Case 1: When L == 0 and R >= 2 * max(X, Y);
 * Case 2: - The generalization of case 1 actually;
 *
 * Case 3: - Actually all cases could be transformed to case 2;
 *         - By get i is the first bit that X and Y are different
 *         - Then the problem is actually transform into the second  problem which breaked in 2 cases: the answer of the i bits is 0 or 1;
 */
public class BitWiseProduct {
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
            int test = in.nextInt();
            long x, y, l, r;
            for (int i = 0; i < test; i++) {
                x = in.nextLong();
                y = in.nextLong();
                l = in.nextLong();
                r = in.nextLong();
                out.println(solver(x, y, l, r));
            }
        }

        static long maximumTwoPower (long x){
            long result = 1;
            while (x > 0){
                x = x / 2;
                result = result * 2;
            }
            return result;
        }

        private long solver(long x, long y, long l, long r) {
            long t = Math.max(x, y);
            if (l == 0 && r >= 2 * t){
                long result = 0;
                long cur = 1;
                if (x == 0 || y == 0){
                    return 0;
                }
                while (x > 0 && y > 0){
                    if (x % 2 == 1 || y % 2 == 1){
                        result = result + cur;
                    }
                    x = x / 2; y = y / 2;
                    cur = cur * 2;
                }
                while (x > 0){
                    if (x % 2 == 1){
                        result = result + cur;
                    }
                    x = x / 2;
                    cur = cur * 2;
                }
                while (y > 0){
                    if (y % 2 == 1){
                        result = result + cur;
                    }
                    y = y / 2;
                    cur = cur * 2;
                }
                return result;
            }
            else{
                long max = -1;
                long result = -1;
                for (long d = l; d <= r; d++){
                    long pro = (x & d) * (y & d);
                    if (pro > max){
                        max = pro;
                        result = d;
                    }
                }
                return result;
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