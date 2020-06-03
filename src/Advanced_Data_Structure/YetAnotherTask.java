package Advanced_Data_Structure;

import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 * Prob D contest codeforces round 88;
 * The target is finding the segment [l, r] for an array a such that sum(a[l:r]) - max(a[l:r]) max;
 * @Key: The Kadane's algorithm is famous for solving the problem involving finding the maximum value of a[l:r];
 * Now what we do is trying to utilize such algorithm to solve this problem.
 */
public class YetAnotherTask {
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
            int a[] = new int[n];
            int i, j;
            for (i=0; i < n; i++){
                a[i] = in.nextInt();
            }
            long result = 0;
            for (int max = 1; max <= 30; max++){
                i = 0;
                long cur_sum = 0;
                long max_sum = 0;
                while (i < n){
                    cur_sum += (a[i] > max ? Integer.MIN_VALUE : a[i]);
                    max_sum = Math.max(max_sum, cur_sum);
                    if (cur_sum < 0){
                        cur_sum = 0;
                    }
                    i++;
                }
                result = Math.max(result, max_sum - max);
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