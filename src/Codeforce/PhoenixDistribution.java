package Codeforce.div2;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Tran Anh Tai
 * @link: https://codeforces.com/contest/1348/problem/C
 * @comments: my solution is lengthy and monotonous;
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
            String result ="";
            int j = 0;
            while (j < 26 && cnt[j] == 0){
                j++;
            }
            if (cnt[j] < k){
                while (k > 0 && k > cnt[j]){
                    k -= cnt[j++];
                }
                result += (char)('a' + j);
            }
            else if (cnt[j] > k){
                if (cnt[j] != n) {
                    result += add((char) ('a' + j), cnt[j] - (k - 1));
                    for (int x = j + 1; x < 26; x++) {
                        result += add((char) ('a' + x), cnt[x]);
                    }
                }
                else{
                    result +=  add((char) ('a' + j), cnt[j] / k + (cnt[j] % k == 0 ? 0 : 1));
                }
            }
            else{
                int au = cnt[j];
                result += add((char)('a' + j), 1);
                j++;
                while (j < 26 && cnt[j] == 0){
                    j++;
                }
                if (j < 26){
                    if (au + cnt[j] == n){
                        result += add((char)('a'+ j), cnt[j] / k + (cnt[j] % k == 0 ? 0 : 1));
                    }
                    else{
                        for (int x = j; x < 26; x++){
                            result += add((char)('a' + x), cnt[x]);
                        }
                    }
                }
            }
            out.println(result);
        }
    }

    private String add(char c, int cnt) {
        String result = "";
        while (cnt > 0){
            result += c;
            cnt--;
        }
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