package Dynamic_Programming;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * ProF div 2 #641
 * A GOOD sequence of length p: for each k > 1 presented in the sequence, there exist 2 index i < j such that p[i] == k - 1 && p[j] == k;
 * The task is to calculating sigma (f(p, k)) for every GOOD p sequence with length n and k in range [1, n];
 */
public class SlimeAndSequences {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task Fsolver = new Task();
        Fsolver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{
        static int MOD = 998244353;
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[][] dp = new long[n + 1][n + 1];// dp[i][j]: total number of the number i existed in a j length GOOD sequence;
            long[][] no = new long[n + 1][n + 1]; // no[i][j]: total number of sequence with the maximum element i and j length;
            long[] ans = new long[n + 1]; // total number of i existed in all GOOD sequence with length n;
            int i, j;
            for (i = 1; i <= n; i++){
                dp[i][i] = 1;
                no[i][i] = 1;
            }
            for (j = 1; j <= n; j++){
                for (i = 1; i < j; i++){
                    no[i][j] = ((i - 1) * no[i][j - 1] + no[i - 1][j - 1] + no[i][j - 1]) % MOD;
                }
            }
            for (j = 1; j <= n; j++){
                for (i = 1;i < j; i++){
                    dp[i][j] = ((i - 1) * dp[i][j - 1] + (no[i - 1][j - 1] +  no[i][j - 1]) + dp[i][j - 1]) % MOD;
                }
            }
            for (i = 1; i <= n; i++){
                out.print(dp[i][n] + " ");
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
