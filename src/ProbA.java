
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class ProbA {
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
            int test = Integer.parseInt(in.nextToken());
            for (int i = 0; i < test; i++) {
                int n = in.nextInt();
                int x= in.nextInt();
                int a[] = new int[n];
                int odd = 0, even = 0;
                //Map<Integer, Boolean> m = new HashMap<>();
                for (int j = 0; j < n; j++){
                    a[j] = in.nextInt();
                  //  if (!m.getOrDefault(a[j], false)){
                        if (a[j] % 2 == 1) {odd++;}
                        else {even++;}
                      //  m.put(a[j], true);
                    //}
                }
                if (odd == 0){
                    out.println("No");
                }
                else{
                    x -= even;
                    if (x <= 1){
                        out.println("Yes");
                    }
                    else{
                        boolean stop = false;
                        if (x % 2 == 0){
                            if (even != 0) x++;
                            else {
                                out.println("No");
                                stop = true;
                            }
                        }
                        if (!stop){
                        if (x <= odd){
                            out.println("Yes");
                        }
                        else{
                            out.println("No");
                        }}
                    }
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