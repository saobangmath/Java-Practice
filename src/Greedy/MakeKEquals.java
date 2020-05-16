package Greedy;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * Prob F div 3 #629
 */
public class MakeKEquals {
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
            long pre[] = new long[n + 1];
            long result = Long.MAX_VALUE;
            long l, r;
            long total = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                total += a[i];
            }
            Arrays.sort(a);
            for (int i = 1; i <= n; i++){
                pre[i] = pre[i - 1] + a[i - 1];
            }
            for (int i = 1; i <= n; i++){

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
