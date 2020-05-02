package Competitive_Programming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class Isolation {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader1 in = new InputReader1(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }
}
class TaskB{
    static int cnt[] = new int[26];
    public void solve(InputReader1 in, PrintWriter out) {
        int test = in.nextInt();
        int n, q, j, k, c, wait;
        for (int i = 0; i < test; i++) {
            Arrays.fill(cnt, 0);
            n = in.nextInt();
            q = in.nextInt();
            String s = in.nextToken();
            for (j = 0; j < n; j++){
                cnt[s.charAt(j) -  'a']++;
            }
            for (j = 0; j < q; j++){
                c = in.nextInt();
                wait = 0;
                for (k = 0; k < 26; k++){
                    wait += Math.max(0, cnt[k] - c);
                }
                out.println(wait);
            }
        }
    }
}

class InputReader1 {
    BufferedReader br;
    StringTokenizer st;

    public InputReader1(InputStream stream) {
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