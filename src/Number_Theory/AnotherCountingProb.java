package Number_Theory;

import java.io.*;
import java.util.StringTokenizer;
// given a, b and q queries
// each queries consist of 2 integer Li, Ri;
// find the number of integer between Li, Ri such that ((x % a) % b) != ((x % b ) % a);
/**
@author Tran Anh Tai
 Ideas: if (a == b): return 0 directly;
 else WLOG, a > b -> let x = by + d with d is the remainder when x is divided by b;
 hence, the condition is equivalent to (by) not divided by a;
 hence, y is divided by (b / gcd(a, b));
 x = lcm(a, b) * t + d; with d < b;
 //what to do now is calculating the number of x such that by is divided by a; (1)
 Then the answer is the complement of (1) = (total number of number in range [Li, Ri] - (1));
 */
public class AnotherCountingProb {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    static class Task{
        public void solve(InputReader in, PrintWriter out) {
            int test = in.nextInt();
            int a,b,q;
            long r, l;
            for (int i = 0; i < test; i++) {
                a = in.nextInt();
                b = in.nextInt();
                q = in.nextInt();
                int lcm = (a * b) / gcd(a, b);
                if (b < a){
                    b = a;
                }
                for (int j = 0; j < q; j++){
                    l = in.nextLong();
                    r = in.nextLong();
                    long au = 0;
                    for (int re = 0; re < b; re++){
                        au += (cnt(r, re, lcm) - cnt(l - 1, re, lcm));
                    }
                    // the result is the total number - (the number of number in range[l, r] that satisfied the reverse condition);
                    long result = (r - l + 1) - au;
                    out.print(result + " ");
                }
                out.println();
            }
        }
        // count the total number of integer x < l such that (x % a == d);
        public static long cnt(long l, int d, int a){
            if (l < d){
                return 0;
            }
            int start = 0;
            long end = (l - d) / a;
            return (end - start + 1);
        }
        // gcd function
        public static int gcd(int a, int b){
            if (a == 0){
                return b;
            }
            else{
                return gcd(b % a, a);
            }
        }
    }

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
