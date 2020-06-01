
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class ProbB {
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
            int test = Integer.parseInt(in.nextToken());
            for (int i = 0; i < test; i++) {
                String s = in.nextToken();
                int l = s.length();
                int j;
                int cnt[] = new int[l + 1];
                for (j = 0; j < l; j++){
                    cnt[j+1]  = cnt[j] +  (s.charAt(j) == '1' ? 1 : 0);
                }
                int result = Math.min(cnt[l], l - cnt[l]);
                for (j = 1; j <= l - 1; j++){
                    result = Math.min(result, Math.min(cnt[j], j - cnt[j]) + Math.min(cnt[l] - cnt[j], (l - j) - (cnt[l] - cnt[j])));
                }
                out.println(result);
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