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
           long u = in.nextLong();
           long v = in.nextLong();
           if (u > v || v % 2 != u % 2){
               out.println(-1);
               return;
           }
           if (u == v){
               if (u != 0){
                   out.println(1);
                   out.println(u);
               }
               else{
                   out.println(0);
               }
           }
           else{
               long xor = u;
               long and = (v - u) / 2;
               String s1 = "", s2 =  "";
               boolean ok = true;
               boolean set = true;
               while (and > 0 || xor > 0){
                   int d1 = (int)(xor % 2);
                   int d2 = (int)(and % 2);
                   if (d1 == 1 && d2 == 1){
                       ok = false;
                       break;
                   }
                   if (d1 == 0 && d2 == 0){
                       s1 = "0" + s1;
                       s2 = "0" + s2;
                   }
                   else if (d1 == 0){
                       s1 = "1" + s1;
                       s2 = "1" + s2;
                   }
                   else{
                       if (set){
                           s1 = "1" + s1;
                           s2 = "0" + s2;
                       }
                       else{
                           s1 = "0" + s1;
                           s2 = "1" + s2;
                       }
                       set = !set;
                   }
                   xor/= 2; and/= 2;
               }
               if (ok){
                   out.println(2);
                   out.println(eval(s1) +  " "  + eval(s2));
               }
               else{
                   out.println(3);
                   out.println(u + " " + (v - u) / 2 +  " " + (v - u) / 2);
               }
           }
        }
        static long eval(String s){
            long result = 0;
            int l = s.length();
            for(int i = 0; i < l; i++){
                result = (result * 2 + (s.charAt(i) - '0'));
            }
            return result;
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