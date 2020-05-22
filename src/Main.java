import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
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
        static int a[] = new int[200001];
        static long pre1[] = new long[200001]; // a1, a1 -a2; a1 - a2 + a3, .......;
        static long pre2[] = new long[200001]; // a1, a1 - 2 * a2 + 3 * a3 - .......;
        public void solve(InputReader in, PrintWriter out) {
           int t = in.nextInt();
           for (int test = 1; test <= t; test++){
               out.print("Case #" + test + ": ");
               int n = in.nextInt();
               int q = in.nextInt();
               int i;
               // store pre1[i], pre2[i];
               for (i = 1; i <= n; i++){
                   a[i] = in.nextInt();
                   if (i % 2 == 1){
                       pre1[i] += a[i];
                       pre2[i] += i * a[i];
                   }
                   else{
                        pre1[i] -= a[i];
                        pre2[i] -= i * a[i];
                   }
               }
               for (i = 1; i <= q; i++){
                   String[] token = in.nextToken().split(" ");
                   char ins = token[0].charAt(0);
                   int l = Integer.parseInt(token[1]);
                   int r = Integer.parseInt(token[2]);
                   if (ins == 'U'){
                       int inc = r - a[l];
                       a[l] = r;
                       if (i % 2 == 1){
                           pre1[i] += inc;
                           pre2[i] += inc * i;
                       }
                       else{
                           pre1[i] -= inc;
                           pre2[i] -= inc * i;
                       }
                   }
                   // query from l to r;
                   else{

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