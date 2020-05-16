package Dynamic_Programming;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * ProbE div 3 #642;
 */
public class KPeriodicGarland {
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
        int[] pref = new int[1000001];
        int[] cnt = new int[1000001];
        public void solve(InputReader in, PrintWriter out) {
            int test = Integer.parseInt(in.nextToken());
            int i, j, total, mini;
            for (i = 0; i < test; i++) {
                int n = in.nextInt();
                int k = in.nextInt();
                mini = Integer.MAX_VALUE;
                total = 0;
                String p = in.nextToken();
                Arrays.fill(cnt, 0, k, 0); //  reset count array
                for (j = 0; j < n; j++){
                    cnt[j % k] += (p.charAt(j) - '0'); // count in the array how many lamp is already set with (each position mod k)
                    total += (p.charAt(j) - '0'); // total set lamps at first;
                }
                for (j = 0; j < k; j++){ // for each position mod k ==  0 to k - 1;
                    pref[0] = 0;
                    int cur = 1;
                    int t = j;
                    while (t < n){
                        pref[cur] = pref[cur - 1] + (p.charAt(t) - '0');
                        t += k; cur++;
                    }
                    int dp[] = new int[cur]; // dp[j] = minimum set steps to transform the array into GOOD array and the last set bit is at position j;
                    for (t = 1; t < cur; t++){
                        dp[t] = Math.min(dp[t - 1], pref[t - 1] - pref[0]) + //  the i - 1 bit is set| clear all before bit j;
                                (p.charAt((t - 1) * k + j) == '1' ? 0 : 1); // if bit j is set -> no need additional swap;
                        mini = Math.min(mini, dp[t] + (pref[cur - 1] - pref[t]) - cnt[j]);
                    }
                }
                out.println(total + Math.min(mini, 0)); // consider the case when all lamps are off also;
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
