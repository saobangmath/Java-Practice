package Greedy;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 * @Link: https://codeforces.com/contest/1370/problem/E
 * @Ideas: 1. Optimally, all indexes i such that s[i] == t[i] should not make the operation on!
 *         2. Others indexes in 2 types:
 *              1. s[i] == 0 t[i] == 1;
 *              2. s[i] == 1 t[i] == 0; -> push those indexes into a list L
 *
 *         3. Now trying to concatenate those type if they are the same type and stands consecutively in the list L;
 *         4. Interestingly, the answer is the maximum abs(any sub array of L)!!
 *         5. The formal proof could be founded in the editorials in the link given above;
 */
public class BinarySubsequenceRotation {
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
        ArrayList<Integer> seg = new ArrayList<>();
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String s = in.nextToken();
            String t = in.nextToken();
            int cnt[] = new int[2];
            int pre = -1, count = 0;
            for (int i = 0; i < n; i++){
                int c1 = s.charAt(i) - '0';
                int c2 = t.charAt(i) - '0';
                cnt[c1]++;
                cnt[c2]--;
                if (c1 == 0 && c2 == 1){
                    if (pre == -1){
                        count = 1;
                        pre = 0;
                    }
                    else if (pre == 0){
                        count++;
                    }
                    else{
                        seg.add(-count);
                        pre = 0;
                        count = 1;
                    }
                }
                else if (c1 == 1 && c2 == 0){
                    if (pre == -1){
                        count = 1;
                        pre = 1;
                    }
                    else if  (pre == 1){
                        count++;
                    }
                    else{
                        seg.add(count);
                        pre = 1;
                        count = 1;
                    }
                }
            }
            if (pre == 1){
                seg.add(-count);
            }
            else{
                seg.add(count);
            }
            if(cnt[0] != 0){
                out.println(-1);
            }
            else{
                out.println(Math.max(get(1), get(-1)));
            }
        }

        private int get(int isPositive) {
            int max = 0;
            int cur = 0;
            for (int i = 0; i < seg.size(); i++){
                cur += seg.get(i) * isPositive;
                max = Math.max(max, cur);
                cur = Math.max(0, cur);
            }
            return max;
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
