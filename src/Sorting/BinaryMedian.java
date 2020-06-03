package Sorting;


import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class BinaryMedian {
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
                int m = in.nextInt();
                String s;
                String result = "0";
                int d = 1; // right - left;
                for (int j = 0; j  < m - 1; j++){
                    result += "1";
                }
                Map<String, Boolean> mp = new HashMap<>();
                for (int j = 0; j < n; j++){
                    s = in.nextToken();
                    if (d == 1){
                        if (s.compareTo(result) <= 0){
                            while (true){
                                String nxt = next(result);
                                result = nxt;
                                if (!mp.getOrDefault(nxt, false)){
                                    break;
                                }
                            }
                        }
                    }
                    else{
                        if (s.compareTo(result) >= 0){
                            while (true){
                                String prv = prev(result);
                                result = prv;
                                if (!mp.getOrDefault(prv, false)){
                                    break;
                                }
                            }
                        }
                    }
                    d = 1 - d;
                    mp.put(s, true);
                }
                out.println(result);
            }
        }
        static String next(String binary){
            String result =  "";
            int l = binary.length();
            int i;
            for (i = l - 1; i >= 0; i--){
                if (binary.charAt(i) == '0'){
                    break;
                }
            }
            result += binary.substring(0, i)+ "1";
            for (int j = i + 1;j < l; j++){
                result += '0';
            }
            return result;
        }
        static String prev(String binary){
            String result =  "";
            int l = binary.length();
            int i;
            for (i = l - 1; i >= 0; i--){
                if (binary.charAt(i) == '1'){
                    break;
                }
            }
            result += binary.substring(0, i)+ "0";
            for (int j = i + 1;j < l; j++){
                result += '1';
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