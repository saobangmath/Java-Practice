package Greedy;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * Prob E div 2 contest #643
 * We have some pillars of bricks with different heights h1, h2, ...
 * We have 3 available operations:
 * 1. Add one brick to the top of any pillar: cost A
 * 2. Remove one brick from the top of any pillar: cost R
 * 3. Move one brick from the top of any pillar to another one: cost M
 * The target is finding the minimum cost available to get all of the pillars in the same height before some operations.
 */
public class RestorerDistance {
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
            int a = in.nextInt(); // one add operation cost;
            int r = in.nextInt(); // one remove operation cost;
            int m = in.nextInt(); // one move operation cost;
            // all brick height;
            int h[] = new int[n];
            // prefix sum;
            long pre[] = new long[n + 1];
            long total = 0;

            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }
            Arrays.sort(h);
            for (int i = 1; i <= n; i++){
                pre[i] = pre[i - 1] + h[i - 1];
            }
            total = pre[n];
            long result = Long.MAX_VALUE;
            if (n == 1){
                out.println(0);
                return;
            }
            for (int i = 1; i <= n; i++){
                // from i + 1 -> n increase;
                // from 1 to i decrease;
                if (i == 1){
                    result = Math.min(result, r * (total - (long)h[0] * n));
                }
                else if  (i == n){
                    result = Math.min(result, a * (long)h[n - 1] * n - total);
                }
                else{
                    long remove = (total - pre[i]) - h[i - 1] * (n - i);
                    long add = h[i - 1] * (i) - pre[i];
                    if (remove >= add){
                        // add: add * a + remove * r;
                        //remove than add: add* m + (remove - add) * r;
                        if (a > m - r){
                            result= Math.min(result, add * (m - r)  + remove * r);
                        }
                        else{
                            result = Math.min(result, add * a + remove * r);
                        }
                    }
                    else{
                        // remove: add * a + remove * r;
                        // add than remove: remove * m + (add - remove) * a;
                        if (m - a > r){
                            result = Math.min(result, add * a + remove * r);
                        }
                        else{
                            result = Math.min(result, add * a + remove * (m - a));
                        }
                    }
                }
            }
            long[] threshold = new long[2];
            threshold[0] = divide(total, n);
            threshold[1] = total / n;
            for (int j = 0; j < 2; j++){
                total = threshold[j];
                long remove = 0;
                long add = 0;
                for (int i = 0; i < n; i++){
                    if (h[i] > total){
                        remove += (h[i] - total);
                    }
                    else{
                        add += (total - h[i]);
                    }
                }
                if (remove >= add){
                    // add: add * a + remove * r;
                    //remove than add: add* m + (remove - add) * r;
                    if (a > m - r){
                        result= Math.min(result, add * (m - r)  + remove * r);
                    }
                    else{
                        result = Math.min(result, add * a + remove * r);
                    }
                }
                else{
                    // remove: add * a + remove * r;
                    // add than remove: remove * m + (add - remove) * a;
                    if (m - a > r){
                        result = Math.min(result, add * a + remove * r);
                    }
                    else{
                        result = Math.min(result, add * a + remove * (m - a));
                    }
                }
            }
            out.println(result);
        }

        private long divide(long total, int n) {
            long result = total / n;
            if (result * n == total){
                return result;
            }
            else{
                return result + 1;
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