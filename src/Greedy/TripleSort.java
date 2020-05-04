package Greedy;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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
}
class Task{
    static int[] a = new int[200001];
    static boolean[] mark = new boolean[200001];
    public void solve(InputReader in, PrintWriter out) {
        int test = Integer.parseInt(in.nextToken());
        int n, k, j;
        for (int i = 0; i < test; i++) {
            n = in.nextInt();
            k = in.nextInt();
            int ops = 0, even = 0;
            boolean no = false;
            Arrays.fill(mark, false);
            ArrayList<ArrayList<Integer>> all = new ArrayList<>();
            for (j = 1; j <= n; j++){
                a[j] = in.nextInt();
            }
            for (j = 1; j <= n; j++){
                if (!mark[j]){
                    ArrayList<Integer> au = dfs(j);
                    int size = au.size();
                    ops += (size - 2) / 2;
                    if (size % 2 == 0){
                        even++;
                    }
                    else{
                        ops++;
                        all.add(au);
                    }
                    if (ops > k){
                        no = true;
                        break;
                    }
                }
            }
            if (even % 2 == 1){
                no = true;
            }
            else{
                ops += even / 2;
            }
            if (no){
                out.println(-1);
            }
            else{
                out.println(ops);
                for (ArrayList<Integer> lst : all){
                    int l = lst.size();
                    for (j = 1; j < l - 1; j += 2){
                        out.println(lst.get(0) + " " + lst.get(j) + " " + lst.get(j + 1));
                    }
                }
            }
        }
    }
    static ArrayList<Integer> dfs(int src){
        ArrayList<Integer> result = new ArrayList<>();
        int au = src;
        while (a[au] != src){
            mark[au] = true;
            result.add(au);
            au = a[au];
        }
        mark[au] = true;
        result.add(au);
        return result;
    }
}

class InputReader {
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