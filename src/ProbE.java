
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @https://codeforces.com/contest/1363/problem/E
 * ProbE contest div 2 #646: A kind of dp on Tree: find the minimum cost required for changing all binary written in each node to the desired value with each node has its own value;
 * Ideas:
 * @Key: Let a node i with its parent is node p -> if a[p] < a[i]: the node shuffling operation for the node i will be performed on the node p instead for minimize the cost;
 */
public class ProbE {
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