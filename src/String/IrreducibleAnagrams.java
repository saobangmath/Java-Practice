package String;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * Prob D contest #616 Div 2;
 * Some funny anagrams problem;
 */
public class IrreducibleAnagrams {
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
        static int[][] cnt = new int[200001][26];
        public void solve(InputReader in, PrintWriter out) {
            String s = in.nextToken();
            int l = s.length();
            int q = in.nextInt();
            int i, j;
            for (i = 1; i <= l; i++){
                for (j = 0; j < 26; j++){
                    cnt[i][j] = cnt[i - 1][j];
                }
                ++cnt[i][s.charAt(i - 1) - 'a'];
            }
            for (i = 0; i < q; i++) {
                int left = in.nextInt();
                int right = in.nextInt();
                boolean flag = false;
                if (right == left){
                    flag = true;
                }
                else{
                    int count = 0;
                    for (j = 0; j < 26; j++){
                        if (cnt[right][j] - cnt[left - 1][j] > 0) count++;
                    }
                    if (count > 2){
                        flag = true;
                    }
                    else if (count == 2){
                        flag = (s.charAt(left - 1) != s.charAt(right - 1));
                    }
                    else{
                        flag = false;
                    }
                }
                out.println(flag ? "Yes" : "No");
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
