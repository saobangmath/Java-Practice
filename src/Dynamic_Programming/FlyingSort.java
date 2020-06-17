package Dynamic_Programming;


import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 * this is a problem with 2 version namely EASY and HARD
 * @Easy:https://codeforces.com/problemset/problem/1367/F1
 * @Hard:https://codeforces.com/problemset/problem/1367/F2
 * @Key: 1. The key for this problem to find a longest subsequence that form a contigous of array au = SORTED(Initial array);
 *       2. Store all (key, value) pair in a HashMap with key is the value and value is the list of the index j which a[j] == value;
 *       3. Then, for value x ( from maximum to minimum) as the beginning of the subsequence
 *       4. Start from the index i which is the minimum value of x such that a[i] = x,
 *       5. If the minimum index of the next value with x is > i (min), 2 options considered, from x -> min,
 *            1. count the number of x, then dp[next_value] + count;
 *            2. try to extends x value as much as possible (might have some optimization for this one in implementations)
 *       6. Else, try to extends x as much as possible as well as counting the number of next_value left to update the maximum result;
 * @Disclaimer: This solution is merely work for the easy version while the core idea above is similar for both version
 */
public class FlyingSort {
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
            int t =  in.nextInt();
            for (int i = 0; i < t; i++){
                int n = in.nextInt();
                int a[] = new int[n];
                Map<Integer, Integer> pos = new HashMap<>();
                for (int j = 0; j < n; j++){
                    a[j] = in.nextInt();
                    pos.put(a[j], j);
                }
                int b[] = a.clone();
                int dp[] = new int[n];
                Arrays.sort(b);
                dp[0] = 1;
                int max = 1;
                for (int j = 1; j < n; j++){
                    dp[j] = 1;
                    if (pos.get(b[j]) > pos.get(b[j - 1])){
                        dp[j] = dp[j - 1] + 1;
                    }
                    max = Math.max(max, dp[j]);
                }
                out.println(n - max);
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
