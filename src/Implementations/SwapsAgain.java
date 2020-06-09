package Implementations;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * @Link:https://codeforces.com/contest/1365/problem/F
 * @Contest Codeforce div 2 #648
 * @ProblemF
 * @Key: 1. The key for this problem is for every time performing swapping operation with suffix and prefix, the multiset {{a[i], a[n - i - 1]}} (n is the length of the array) is unchanged!!!
 *       2. With every 2 array a, b that have such multiset are exactly similar, one array could be constructed from others!! This could derive by constructing strategy from middle elements to outer elements.
 *       3. Moreover, the number of steps use is no more than [3*n/2];
 */
public class SwapsAgain {
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
                int b[] = new int[n];
                for (int j = 0; j < n; j++){
                    a[j] = in.nextInt();
                }
                for (int j = 0; j < n; j++){
                    b[j] = in.nextInt();
                }
                // if the array withb odd element, the middle elements is static, never be touched, so it should be the same on both array;
                if (n % 2 == 1 && a[n / 2] != b[n / 2]){
                    out.println("No");
                }
                else{
                    Pair[] a_pairs = new Pair[n / 2];
                    Pair[] b_pairs = new Pair[n / 2];
                    for (int j = 0; j < n / 2; j++){
                        int x1 = Math.min(a[j], a[n - 1 - j]);
                        int y1 = Math.max(a[j], a[n - 1 - j]);
                        int x2 = Math.min(b[j], b[n - 1 - j]);
                        int y2 = Math.max(b[j], b[n - 1 - j]);
                        a_pairs[j] = new Pair(x1, y1);
                        b_pairs[j] = new Pair(x2, y2);
                    }
                    // sort 2 multiset in order to check if they are equal;
                    Arrays.sort(a_pairs);
                    Arrays.sort(b_pairs);
                    boolean ok = true;
                    // check if all the multiset are equals for the two array;
                    for (int j = 0; j < n / 2; j++){
                        if (a_pairs[j].equals(b_pairs[j])){
                            continue;
                        }
                        else{
                            ok = false;
                            break;
                        }
                    }
                    if (ok) out.println("Yes");
                    else out.println("No");
                }
            }
        }
    }
    // Pair
    static class Pair implements Comparable<Pair>{
        public int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x > o.x){
                return 1;
            }
            else if (this.x < o.x){
                return -1;
            }
            else{
                if (this.y < o.y){
                    return -1;
                }
                else if (this.y > o.y){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair &&
                    this.x == ((Pair)obj).x &&
                    this.y == ((Pair)obj).y;
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
