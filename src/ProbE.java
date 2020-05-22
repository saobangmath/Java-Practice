import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * Prob E div 2 contest #81
 * It is not hard to think about the ideas and solution but my thinking is not so clear enough to implement this problem fast in a real contest.
 * The clear thinking is such an important thing!
 */
public class ProbE {
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
            int i, j;
            int[] p = new int[n + 1];
            int[] cost = new int[n +  1];
            boolean[] mark = new boolean[n + 1];
            // forward cost to move greater elements to the subarray[i + 1:]
            long[] forward = new long[n + 1];
            // backward cost to move the smaller elements to the subarray[:i + 1:]
            long[] backward = new long[n + 1];
            // pre[i]: prefix sum of cost[:i + 1:]
            long[] pre  = new long[n + 1];
            long result;
            long total = 0;
            // permutation input;
            for (i = 1; i <= n; i++){
                p[i] = in.nextInt();
            }
            // cost reader and prefix sum update;
            for (i = 1; i <= n; i++){
                int c = in.nextInt();
                cost[p[i]] = c;
                total += c;
                pre[i] = total;
            }
            result = total;
            for (i = 1; i <= n - 1; i++){
                result = Math.min(result, Math.min(pre[i], total - pre[i]));
            }
            mark[p[1]] = true;
            if (p[1] > 1){
                forward[1] = cost[p[1]];
                backward[1] = cost[1];
            }

            result = Math.min(result, forward[1] + backward[1]);

            for (i = 2; i <= n - 1; i++){
                forward[i] = forward[i - 1];
                backward[i] = backward[i - 1];
                if (p[i] > i) {
                    forward[i] += cost[p[i]];
                    if (!mark[i]){
                        backward[i] += cost[i];
                    }
                    else{
                        forward[i]  -= cost[i];
                    }
                }
                else if (p[i] < i){
                    backward[i] -= cost[p[i]];
                    if (!mark[i]){
                        backward[i] += cost[i];
                    }
                    else{
                        forward[i] -= cost[i];
                    }
                }
                mark[p[i]] = true;
                result = Math.min(result, forward[i] + backward[i]);
            }
            for (i = 1; i <= n; i++){
                out.println(forward[i] + " " + backward[i]);
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
