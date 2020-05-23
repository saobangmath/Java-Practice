package Graphs;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class EhabRealNumberTheory {
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
            int n = in.nextInt();
            int a[] = new int[n];
            boolean mark[] = new boolean[100001];
            int result = 1;
            ArrayList<Integer> primes = new ArrayList<>();
            Map<Integer, Integer> hm = new HashMap<>();
            int cur = 1;
            for (int i = 2; i <= 100000; i++){
                if (!mark[i]){
                    primes.add(i);
                    hm.put(i, cur++);
                    for (int j = 2 * i; j <= 100000; j += i){
                        mark[j] = true;
                    }
                }
            }
            Vector<Integer> E[] = new Vector[cur];
            for (int i = 0; i < cur; i++){
                E[i] = new Vector<>();
            }
            boolean square = false;
            boolean two = false;
            for (int i = 0; i < n; i++){
                a[i] = in.nextInt();
                if (a[i] == 1){
                    square = true;
                    continue;
                }
                int cnt = 0;
                int p = 1;
                for (int prime : primes){
                    if (a[i] % prime == 0){
                        p = prime;
                        while (a[i] % prime == 0){
                            cnt++;
                            a[i] /= prime;
                        }
                        break;
                    }
                }
                if (a[i] == 1){ // only one prime factor;
                    if (cnt % 2 == 0){
                        square = true;
                    }
                    else{
                        if (E[a[i]].contains(1)){
                            two = true;
                        }
                        else{
                            E[hm.get(a[i])].add(1);
                            E[1].add(hm.get(a[i]));
                        }
                    }
                }
                else{
                    int sqrt = (int)(Math.sqrt(a[i]));
                    if (sqrt * sqrt == a[i]){ // sqrt is another prime number;
                        if (cnt % 2 == 0){
                            square = true;
                        }
                        else{

                        }
                    }
                    else{

                    }
                }
            }
            if (square){
                out.println(1);
            }
            else if (two){
                out.println(2);
            }
            else{

            }
        }
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
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}
