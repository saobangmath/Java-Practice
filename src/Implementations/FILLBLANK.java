package Implementations;
import java.util.*;
import java.io.*;

public class FILLBLANK {
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
            int n = in.nextInt();
            int m = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++){
                b[i] = (int)(Math.pow(2, in.nextInt()));
            }
            int cnt = 0;
            Arrays.sort(b);
            Arrays.sort(a);
            int i = 0;
            int j = 0;
            while (i < n){
                if (a[i] >= b[j]){
                    while (j < m && a[i] >= b[j]){
                        a[i] -= b[j++];
                        cnt++;
                    }
                }
                if (j == m){
                    break;
                }
                i++;
            }
            out.println(cnt);
        }

        private int twoPower(int ex) {
            if (ex == 0){
                return 1;
            }
            else{
                int au = twoPower(ex / 2);
                if  (ex % 2 == 1){
                    return au * au * 2;
                }
                else{
                    return au * au;
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
