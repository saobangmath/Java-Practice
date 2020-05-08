import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }
    // main solver

    static class Task{
        static int[] p = new int[200000];
        static boolean[] isempty = new boolean[200000];
        public void solve(InputReader in, PrintWriter out) {
            int test = in.nextInt();
            for (int i = 0; i < test; i++){
                int n = in.nextInt();
                int j, k;
                boolean no = true;
                Arrays.fill(isempty, 0, n - 1, true);
                for (j = 0; j < n; j++){
                    p[j] = in.nextInt();
                    int re = (mod(p[j], n) + j) % n;
                    if (!isempty[re]){
                        no = false;
                    }
                    else{
                        isempty[re] = false;
                    }
                }
                if (!no){
                    out.println("NO");
                }
                else{
                    out.println("YES");
                }
            }
        }
        static int mod(int x, int y){
            return (x % y + y) % y;
        }
        private int solver(int n) {
            if (n <= 1){
                return 0;
            }
            if (n == 2){
                return 1;
            }
            else{
                int t = (int)(Math.sqrt(2 * n / 3));
                if ((3 * t * t + t) / 2 > n){
                    t--;
                }
                return 1 + solver(n - (3 * t * t + t) / 2);
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
