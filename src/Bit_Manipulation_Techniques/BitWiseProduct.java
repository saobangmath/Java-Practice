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

        // two utils functions to convert bits array to long value;
        private static long eval(long[] bits){
            long result = 0;
            for (long bit : bits){
                result = result * 2 + bit;
            }
            return result;
        }
        // the function calculating (X and Z) * (Y and Z);
        private static long func(long[] bitX, long[] bitY, long[] bitZ){
            long XandZ[] = new long[63];
            long YandZ[] = new long[63];
            for (int i = 0; i < 63; i++){
                XandZ[i] = bitX[i] & bitZ[i];
                YandZ[i] = bitY[i] & bitZ[i];
            }
            return eval(XandZ) * eval(YandZ);
        }
        // main function for solving
        private static long solver(long x, long y, long l, long r) {
            if (Math.min(x, y) == 0 || l == r) {
                return l;
            }
            else{
                long[] lBit = new long[63];
                long[] rBit = new long[63];
                long[] xBit = new long[63];
                long[] yBit = new long[63];
                long[] zBit = new long[63];
                int i = 62;
                while (l > 0){
                    lBit[i--] = (l % 2);
                    l = l / 2;
                }
                i = 62;
                while (r > 0){
                    rBit[i--] = (r % 2);
                    r = r / 2;
                }
                i = 62;
                while (x > 0){
                    xBit[i--] = (x % 2);
                    x = x / 2;
                }
                i = 62;
                while (y > 0){
                    yBit[i--] = (y % 2);
                    y = y / 2;
                }
                long max, val, result;
                i = 0;
                while (i < 63 && lBit[i] == rBit[i]){
                    zBit[i] = lBit[i];
                    i++;
                }
                // consider the case when zBit[i] == 0;
                // then in this case, what guaranteed is Z <= R;
                // what we need to find is find Z such that Z >= L;
                zBit[i] = 0;
                boolean more = false;
                for (int j = i + 1; j < 63; j++){
                    if (more){
                        zBit[j] = xBit[j] | yBit[j];
                    }
                    else{
                        zBit[j] = xBit[j] | yBit[j] | lBit[j];
                        if (zBit[j] > lBit[j]){
                            more = true;
                        }
                    }
                }
                max = func(xBit, yBit, zBit);
                // if the maximum value is just zero, than merely takes the minimum value l;
                if (max == 0){
                    result = eval(lBit);
                }
                else {
                    result = eval(zBit);
                }
                // now considered the cased when zBit[i] == 1;
                // then the condition Z >= L is alr satisfied;
                // what we need is to find Z such that Z <= R;
                zBit[i] = 1;
                for (int j = i + 1; j < 63; j++){
                    if (rBit[j] == 1){
                        zBit[j] = 0;
                        for (int k = j + 1; k < 63; k++){
                            zBit[k] = xBit[k] | yBit[k];
                        }
                        val = func(xBit, yBit, zBit);
                        if (val > max){
                            max = val; result = eval(zBit);
                        }
                        zBit[j] = 1;
                    }
                    else{
                        zBit[j] = 0;
                    }
                }
                val = func(xBit, yBit, zBit);
                for (int z = 0; z< 63;z++){
                    assert (zBit[z] == rBit[z]);
                }
                if (val > max) {
                    result = eval(zBit);
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