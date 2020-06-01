package Graphs;


import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @https://codeforces.com/contest/1363/problem/E
 * ProbE contest div 2 #646: A kind of dp on Tree: find the minimum cost required for changing all binary written in each node to the desired value with each node has its own value;
 * Ideas:
 * @Key:
 * 1. Let a node i with its parent is node p -> if a[p] < a[i]: the node shuffling operation for the node i will be performed on the node p instead for minimize the cost;
 * 2. We will only swap the node with current value 1 - desired value 0 (TYPE 1)  or vice versa (TYPE 2);
 * 3. No perform shuffling on the node with the same value with both current value and desired value;
 * @Trick: for many Tree problem, with the node numbered from 1-> n, we could add an auxiliary root zero for more convenient in coding.
 */
public class TreeShuffling {
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
        static int N = 200005;
        static long a[] = new long[N];
        static int b[] = new int[N];
        static int c[] = new int[N];
        static long cost = 0; // result;
        ArrayList<Integer> E[] = new ArrayList[N];
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int i;
            for (i = 1; i <= n; i++){
                E[i] = new ArrayList<>();
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                c[i] = in.nextInt();
            }
            for (i = 0; i < n - 1; i++){
                int u = in.nextInt();
                int v = in.nextInt();
                E[u].add(v); E[v].add(u);
            }
            int remain[] = dfs(1, 0, 2000000009);
            if (remain[0] > 0 || remain[1] > 0){
                out.println(-1);
            }
            else{
                out.println(cost);
            }
        }

        /**
         * return an array with 2 elements: remained number of TYPE 1, TYPE 2 node respectively;
         * Update the minimum cost upward from the leaf up to parent;
         * @param i
         * @param par
         * @param weight
         * @return
         */
        private int[] dfs(int i, int par, long weight) {
            int remain[] = new  int[]{0, 0};
            if (b[i] != c[i]){
                if (b[i] == 1) remain[0]++;
                else remain[1]++;
            }
            for (int dest : E[i]){
                if (dest == par){ // avoid infinity loop;
                    continue;
                }
                int[] au = dfs(dest, i, Math.min(weight, a[i]));
                remain[0] += au[0];
                remain[1] += au[1];
            }
            if (a[i] < weight){ // the remain will be handle by node i instead of its parent(root);
                int taken = Math.min(remain[0], remain[1]);
                cost += 2 * taken * a[i];
                remain[0] -= taken;
                remain[1] -= taken;
            }
            return remain;
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