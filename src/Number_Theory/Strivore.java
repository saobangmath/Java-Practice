package Number_Theory;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @link: https://atcoder.jp/contests/abc171/tasks/abc171_f
 * @Ideas: Just a combinatorial counting problem:
 * The problem is equivalent to count how many string with
 */
public class Strivore {
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
        static int MOD = 1000000007;
        public long pow(long x, long y){
            if (y == 0){
                return 1;
            }
            else{
                long au = pow(x, y / 2);
                au = (au * au) % MOD;
                if (y % 2 == 0){
                    return au;
                }
                else{
                    return (au * x)% MOD;
                }
            }
        }
        public void solve(InputReader in, PrintWriter out){
            int k = in.nextInt();
            String s = in.nextToken();
            int n = s.length();
            long cur = pow(26, k);
            long total = cur;
            for (int last = n + 1; last <= n + k; last++){
                cur = (cur * 25) % MOD;
                cur = (cur * (last -  1)) % MOD;
                cur = (cur * pow(26, MOD - 2)) % MOD;
                cur = (cur * pow(last - n, MOD - 2)) % MOD;
                total = (total + cur) % MOD;
            }
            out.println(total);
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