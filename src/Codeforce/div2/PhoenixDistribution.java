package Codeforce.div2;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class PhoenixDistribution {
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
    static int cnt[] = new int[26];
    public void solve(InputReader in, PrintWriter out) {
        int test = Integer.parseInt(in.nextToken());
        for (int i = 0; i < test; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.nextToken();
            Arrays.fill(cnt, 0);
            for (int j = 0; j < n; j++){
                cnt[s.charAt(j) - 'a']++;
            }
            boolean stop = false;
            for (int j = 0; j < 26; j++){
                if (cnt[i] >= k){
                    out.print((char)('a' + i));
                    break;
                }
                int au = n / k;
                if (cnt[i] == n){ // last ...

                    if (n / k != 0){
                        au++;
                    }
                    for (int x =  0; x <  au; x++){
                        out.print((char)('a'  +  i));
                    }
                }
                k -= cnt[i] % k;
                n -= cnt[i];
            }
            out.println();
        }
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