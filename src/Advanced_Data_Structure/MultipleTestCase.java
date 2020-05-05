package Advanced_Data_Structure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class MultipleTestCase {
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
        static int[] m = new int[200001];
        static int[] c = new int[200001];
        static int[] pref = new int[200001];
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int i;
            for (i = 0; i <= k; i++){
                m[i] = 0;
            }
            for (i = 0; i < n; i++){
                ++m[in.nextInt()];
            }
            for (i = 1; i <= k; i++){
                c[i] = in.nextInt();
                pref[i] = m[i];
            }
            int result = (int)Math.ceil((double)pref[k] / c[k]);
            for (i = k - 1; i >= 1; i--){
                pref[i] = pref[i + 1] + pref[i];
                result = Math.max(result, (int)Math.ceil((double)pref[i] / c[i]));
            }
            List<Integer>[] E = new ArrayList[result];
            for (i = 0; i < result; i++){
                E[i] = new ArrayList<>();
            }
            int cur = 0;
            i = k;
            while (i > 0){
                for (int time = 0; time < m[i]; time++){
                    E[cur].add(i);
                    cur = (cur + 1) % result;
                }
                i--;
            }
            out.println(result);
            for (List<Integer> l : E){
                out.print(l.size() +" ");
                for (int x : l){
                    out.print( x + " ");
                }
                out.println();
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