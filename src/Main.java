import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * Task C div 2 contest #643
 * Kind of problem that not hard to think but implementing has many corner cases!
 * Need to well-prepared more about this kind of problem
 */
public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }
    // main solver

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int x, y, z;
            int s, e;
            long result = 0;
            // choosing the maximum length first;
            for (z = c; z <= d; z++){
                int start = z - b + 1;
                int end = z - b + (b - a) + 1;
                if (end <= b){
                    result += (long)(c - b + 1) * (b - a + 1);
                }
                else if (b <= start){
                    e = Math.max(0,c - start + 1);
                    s = Math.max(0, e - (b - a));
                    result += (long)(s + e) * (e - s + 1) / 2;
                }
                else{
                    result += (long)(2 * b - z) * (c - b + 1);
                    e = (c - b);
                    s = Math.max(0, e - (z - b - a));
                    result += (long)(s + e) * (e - s + 1) / 2;
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