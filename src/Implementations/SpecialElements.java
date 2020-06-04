package Implementations;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @link:https://codeforces.com/contest/1354/problem/E
 * ProbE div 4 contest #640
 */
public class SpecialElements {
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
            int t = in.nextInt();
            for (int i = 0; i < t; i++){
                int n=  in.nextInt();
                int prev[] = new int[n + 1];
                int count[] = new int[8001];
                for (int j = 0; j < n; j++){
                    int num = in.nextInt();
                    prev[j + 1] = prev[j] + num;
                    count[num]++;
                }
                int cnt = 0;
                // simply a two pointer technique
                for (int j = 1; j <= 8000; j++){
                    for (int beg = 0, end = 1; end <= n;){
                        if (end > beg + 1 && prev[end] - prev[beg] == j){
                            cnt += count[j];
                            break;
                        }
                        else if (prev[end] - prev[beg] > j){
                            beg++;
                        }
                        else{
                            end++;
                        }
                    }
                }
                out.println(cnt);
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
