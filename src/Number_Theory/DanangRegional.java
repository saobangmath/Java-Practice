package Number_Theory;
import java.io.*;
import java.util.StringTokenizer;

public class DanangRegional {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{
        static long[][] dp = new long[10000][10];
        public Task(){
            for (int i = 1; i < 10000; i++){
                int j = i;
                for (int d = 0; d <= 9; d++){
                    dp[i][d] =dp[i - 1][d];
                }
                while (j > 0){
                    dp[i][j % 10]++;
                    j = j / 10;
                }
            }
        }
        public void solve(InputReader in, PrintWriter out) {
            int test = in.nextInt();
            for (int i = 0; i < test; i++) {
                int n = in.nextInt();
                for (int j = 0; j <= 9; j++){
                    out.print( dp[n][j] + " ");
                }
                out.println();
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
