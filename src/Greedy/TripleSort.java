package Greedy;


import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class TripleSort {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

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

        public long nextLong() {
            return Long.parseLong(nextToken());
        }
    }
        static class Task {
            static int[] a = new int[200001];
            static boolean[] mark = new boolean[200001];

            public void solve(InputReader in, PrintWriter out) {
                int test = Integer.parseInt(in.nextToken());
                int n, k, j;
                for (int i = 0; i < test; i++) {
                    n = in.nextInt();
                    k = in.nextInt();
                    // set up variable
                    int cnt = 0, odd_ops = 0, even_ops = 0;
                    // mark all the number to be false;
                    Arrays.fill(mark, false);
                    ArrayList<ArrayList<Integer>> odd = new ArrayList<>();
                    ArrayList<ArrayList<Integer>> even = new ArrayList<>();
                    // read input
                    for (j = 1; j <= n; j++) {
                        a[j] = in.nextInt();
                    }
                    // dfs through our points;
                    for (j = 1; j <= n; j++){
                        if (!mark[j]){
                            ArrayList<Integer> au = dfs(j);
                            if (au.size() % 2 == 1){
                                odd_ops += au.size() / 2;
                                odd.add(au);
                            }
                            else{
                                even_ops += (au.size() - 1) / 2;
                                even.add(au);
                                cnt++;
                            }
                        }
                    }
                    int total = odd_ops + even_ops + (cnt);
                    // if (no of even cycles is odd -> return -1 || total  > k;
                    if (cnt % 2 == 1 || total > k){
                        out.println(-1);
                    }
                    // the total number of operations;
                    else{
                        int p, s;
                        out.println(total);
                        // for odd list
                        for (ArrayList<Integer> l : odd){
                            s = l.size();
                            for (p = 1; p < s - 1; p += 2){
                                out.println(l.get(0) + " "+ l.get(p) + " " + l.get(p + 1));
                            }
                        }
                        // for even list processsing;
                        for (ArrayList<Integer> l : even){
                            s = l.size();
                            for (p = 1; p < s - 1; p += 2){
                                out.println(l.get(0) + " " + l.get(p) + " " + l.get(p + 1));
                            }
                        }
                        // for each 2 consecutive even list to merge tgt;
                        for (p = 0; p < cnt - 1; p += 2){
                            List<Integer> l1 = even.get(p);
                            List<Integer> l2 = even.get(p + 1);
                            int x1 = l1.get(0);
                            int y1 = l1.get(l1.size() - 1);
                            int x2 = l2.get(0);
                            int y2 = l2.get(l2.size() - 1);
                            out.println(x1 + " " +  y1 + " " + x2);
                            out.println(y2 + " " +  x2 + " " + x1);
                        }
                    }
                }
            }


            static ArrayList<Integer> dfs(int src) {
                ArrayList<Integer> result = new ArrayList<>();
                int au = src;
                while (a[au] != src) {
                    mark[au] = true;
                    result.add(au);
                    au = a[au];
                }
                mark[au] = true;
                result.add(au);
                return result;
            }
    }
}