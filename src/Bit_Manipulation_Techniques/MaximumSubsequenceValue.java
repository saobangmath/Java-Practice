package Bit_Manipulation_Techniques;


import java.io.*;
import java.util.*;

/**
 * @author: Tran Anh Tai
 * @Link:https://codeforces.com/contest/1365/problem/E
 * @Key: Considering all subset with size k > 3. As at least k - 2 numbers set in the sub-sequence, for every set bit in the result with the whole set of k elements
 * At least one element in the 3-elements choosen has the bit set -> the result for the 3 elements subset also have such bit set!
 * Hence, choosing any subset of 3 elements out of those k elements, the value need to calculated always >= the result for the whole set!
 * Hence considering all set of 3 elements is enough for this problem;
 * O(n^3);
 */
public class MaximumSubsequenceValue{
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
            long a[] = new long[n];
            for (int i = 0; i < n; i++){
                a[i] = in.nextLong();
            }
            long result = a[0];
            for (int i = 0; i < n; i++){
                for (int j = i + 1; j < n; j++){
                    for (int k = j + 1; k <  n; k++){
                        result = Math.max(result,  a[i] | a[j] | a[k]);
                    }
                }
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