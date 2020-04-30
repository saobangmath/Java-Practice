package GoogleKickStart.KickStart_2019;


import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class H_Index {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Tasks solver = new Tasks();
        solver.solve(in, out);
        out.close();
    }
}
class Tasks{
    int[][] a = new int[101][101];
    int[] l = new int[201];
    int[] r = new int[201];
    // a[i][j] = l[i + j] + r[(n - 1) + (j - i)];
    public void solve(FastReader in, PrintWriter out) {
        int test = in.nextInt();
        int j, k;
        String s;
        for (int i = 1; i <= test; i++) {
            int n = in.nextInt();
            out.print("Case #" + i + ": ");
            for (j = 0; j < n; j++){
                s = in.nextToken();
                for (k = 0;
                     k < n; k++){
                    a[j][k] = s.charAt(k) == '.' ? 1 : 0;
                }
            }
            l[0] = 0; l[1] = 0;
            r[n - 1] = a[0][0]; r[n] = a[0][1];
            int white1 = 0;
            int black1 = 0;
            for (j = 2; j < 2 * n; j += 2){
                l[j] = (a[j / 2][j / 2] + r[n - 1]);
                white1 += l[j];
            }
            for (j = 1; j < 2 * n; j += 2){
                l[j] = (a[(j - 1) / 2][(j + 1) / 2]  + r[n]) % 2;
                white1 += l[j];
            }
            for (j = 0; j < 2 * n; j++){
                r[j] = (a[n - 1][j] + l[n - 1 + j]) % 2;
                black1 += r[j];
            }

            l[0] = 1; l[1] = 1;
            r[n - 1] = (a[0][0] + 1) % 2;
            r[n] = (a[0][1] + 1) % 2;
            int white2 = 1;
            int black2 = 1;
            for (j = 2; j < 2 * n; j += 2){
                l[j] = (a[j / 2][j / 2] + r[n - 1]) % 2;
                white2 += l[j];
            }
            for (j = 1; j < 2 * n; j += 2){
                l[j] = (a[(j - 1) / 2][(j + 1) / 2]  + r[n]) % 2;
                white2 += l[j];
            }
            for (j = 0; j < 2 * n; j++){
                r[j] = (a[n - 1][j] + l[n - 1 + j] + 1) % 2;
                black2 += r[j];
            }
            //System.out.println(black + " " + black2 + " " + white + " " + white2);
            int total = Math.min(black1, black2) + Math.min(white1, white2);
            out.println(total);
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStream stream) {
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