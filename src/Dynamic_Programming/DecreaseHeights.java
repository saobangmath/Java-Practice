package Dynamic_Programming;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * probF div 3 contest #642:
 * A dp problem;
 */
public class DecreaseHeights {
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
        static long grid[][] = new long[100][100];
        static long dp[][] = new long[100][100];
        static long LLMAX = Long.MAX_VALUE;
        public void solve(InputReader in, PrintWriter out) {
            int test = Integer.parseInt(in.nextToken());
            for (int i = 0; i < test; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int j, k, x, y;
                long result = LLMAX;
                long au, mini, last;
                for (j = 0; j < n; j++){
                    for (k = 0; k < m; k++){
                        grid[j][k] = in.nextLong();
                    }
                }
                for (j = 0; j < n; j++){
                    for (k = 0; k < m; k++){
                        long fixed = grid[j][k] - (j + k);
                        last = grid[n - 1][m - 1] - (fixed + m - 1 + n - 1);
                        if (last < 0){
                            continue;
                        }
                        else{
                            dp[n - 1][m - 1] = last;
                        }
                        boolean valid = true;
                        // for the last row dp;
                        for (x = m - 2; x >= 0; x--){
                            dp[n - 1][x] = LLMAX;
                            au = grid[n - 1][x] - (fixed + x + n - 1); // initial value, new value;
                            if (au >= 0 && dp[n - 1][x + 1]!= LLMAX){
                                dp[n - 1][x] = au + dp[n - 1][x + 1];
                            }

                        }
                        // for the last column dp;
                        for (y = n - 2; y >= 0; y--){
                            dp[y][m - 1] = LLMAX;
                            au = grid[y][m - 1] - (fixed + m - 1 + y); // initial value, new value;
                            if (au >= 0 && dp[y + 1][m - 1] != LLMAX){
                                dp[y][m - 1] = au + dp[y + 1][m - 1];
                            }
                        }
                        // for other squares dp;
                        for (y = n - 2; y >= 0; y--){
                            for (x = m - 2; x >= 0 ; x--){
                                dp[y][x] = LLMAX;
                                au = grid[y][x] - (fixed + x + y); // initial value -  new value;
                                mini = Math.min(dp[y + 1][x], dp[y][x + 1]);
                                if (au >= 0 && mini != LLMAX){
                                    dp[y][x] = au + mini;
                                }
                            }
                        }
                        if ((dp[0][0] != Long.MAX_VALUE)){
                            result = Math.min(result, dp[0][0]);
                        }
                    }
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
