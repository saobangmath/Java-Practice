package Sorting;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @Link:https://codeforces.com/contest/1370/problem/D
 * @Ideas: binary search the result:
 * - For a value x, greedily build a subsequence from the initial array such that all the elements with odd index or with even index <= x;
 * - If Yes: move the end value to the middle; // as now the middle became the upper_bounded for our result;
 * - If No: move the beginning to the middle + 1; // as now the middle became the lower_bounded for our result;
 */
public class OddEvenSubsequence {
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
    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for  (int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            int beg = 1;
            int end = 1000000000;
            while (beg < end){
                int mid = (beg + end) / 2;
                if (exist(a, mid, k)){
                    end = mid;
                }
                else{
                    beg = mid + 1;
                }
            }
            out.println(beg);
        }
        // exist a subsequence >= k in length with all odd | even indexes elements <= tar;
        private boolean exist(int[] a, int tar, int k) {
            int oddFirst = 0;// all odd indexes elements <= tar;
            int evenFirst = 0; // allEven indexes elements <= tar;
            int i = 1, start;
            // all oddElements <= k;
            start = a[0]; oddFirst = 1;
            while (i < a.length){
                if (a[i] <= tar){
                    if (i != a.length - 1){
                        oddFirst += 2;
                    }
                    else{
                        oddFirst++;
                    }
                    i += 2;
                }
                else{
                    i++;
                }
            }
            // if exist an array with all elements in odd position <= target;
            if (oddFirst >= k){
                return true;
            }
            i = 0;
            while (i < a.length){
                if (a[i] <= tar){
                    if  (i != a.length - 1) {
                        evenFirst += 2;
                    }
                    else{
                        evenFirst++;
                    }
                    i += 2;
                }
                else{
                    i++;
                }
            }
            if (evenFirst >= k){
                return true;
            }else{
                return false;
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
