package Number_Theory;
import java.io.*;
import java.util.*;

public class ModularStability {
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
        static int N = 500000;
        static int MOD = 998244353;
        static long[] fac = new long[N + 1];
        static long[] inv = new long[N + 1];
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n < k){
                out.println(0);
            }
            else{
                fac[0] = 1;
                inv[0] = 1;
                for (int i = 1; i <= n; i++){
                    fac[i] = (fac[i - 1] * i) % MOD;
                    inv[i] = pow(fac[i], MOD - 2);
                }
                long result = 0;
                for (int i = 1; i <= n; i++){
                    int au = n / i - 1;
                    if (au < k - 1){
                        break;
                    }
                    else{
                        long t = ((fac[au] * inv[au - (k - 1)]) % MOD * inv[k - 1]) % MOD;
                        result = (result + t) % MOD;
                    }
                }
                out.println(result);
            }
        }
        static long pow(long x, int y){
            if (y == 0){
                return 1;
            }
            else{
                long au = pow(x, y / 2);
                if (y % 2 == 0){
                    return (au * au) % MOD;
                }
                else{
                    return ((au * au) % MOD * x) % MOD;
                }
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
