import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solve {
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
        static int a[] = new int[100001];
        static int pre[] = new int[100001];
        public void solve(InputReader in, PrintWriter out) {
            int n, k, t;
            int i, j, x, y;
            t = in.nextInt();
            for (i = 0; i < t; i++){
                n = in.nextInt();
                k = in.nextInt();
                boolean exist = false;
                boolean done = false;
                x = -1;
                for (j = 0; j < n;j++){
                    a[j] = in.nextInt();
                    if (a[j] >= k){
                        if (j == 0)pre[j] = 1;
                        else pre[j] = pre[j - 1] + 1;
                    }
                    else{
                        if (j == 0)pre[j] = 0;
                        else pre[j] = pre[j - 1];
                    }
                    if (a[j] == k){
                        exist = true;
                        if (x == -1){
                            x = j;
                        }
                        else if (j - x <= 2){
                            done = true;
                        }
                        x = j;
                    }
                }
                if (!exist){
                    out.println("no");
                }
                else if (done){
                    out.println("yes");
                }
                else{
                    PriorityQueue<Integer> pq = new PriorityQueue<>(new Criteria());
                    for (y = 0; y < n; y++){
                        if (pq.isEmpty()) {
                            pq.offer(y);
                        }
                        else{
                            while (!pq.isEmpty()) {
                                int top = pq.peek();
                                if (top >= y - 2) {
                                    if (2 * pre[top] - top <= 2 * pre[y] - y) {
                                        done = true;
                                        break;
                                    }
                                }
                                else{
                                    pq.poll();
                                }
                            }
                            pq.offer(y);
                        }
                    }
                    if (done){
                        out.println("yes");
                    }
                    else{
                        out.println("no");
                    }
                }
            }
        }
        static class Criteria implements Comparator<Integer>{

            @Override
            public int compare(Integer o1, Integer o2) {
                if (2 * pre[o1] - o1 > 2 * pre[o2] - o2){
                    return 1;
                }
                else if (2 * pre[o2] - o2 > 2 * pre[o1] - o1){
                    return -1;
                }
                else{
                    if (o1 > o2){
                        return o2;
                    }
                    else{
                        return o1;
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
