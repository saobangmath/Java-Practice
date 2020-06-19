package Greedy;
import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @Link:https://codeforces.com/contest/1175/problem/D
 * @Ideas: the ideas is using the suffix sum of the initial array:
 * 1. suffix[i]: the sum of the sub array from i -> n - 1;
 * 2. Let p1, p2,.. ,pk are the beginning of the i group;
 * 3. Then the sum we must optimize is:
 *      P = 1 * (suffix[p1] - suffix[p2]) + ..... + (k - 1) * (suffix[p(k-1)] - suffix[p(k)]) + k * suffix[p(k)]
 *      Then, P = suffix[p1] + suffix[p2] + .... + suffix[p(k - 1)];
 *      With p1 p1 is 1 already, then our jobs is merely choosen the first k biggest suffixes sum from the suffix array greedily!!
 * @Takeaway: This is a very interesting problem not only it is cool ideas but also because of its implementations.
 * At first, by storing the suffix array into the array then using Arrays.sort() on such array it faces the TLE on the system tests.
 * While switching to store the array on List will passed! This is because the Arrays.sort() using the Quicksort algorithm which could be O(n ^ 2) in worst cases!!
 *                                                         While the Collections.sort() in general is slower then quicksort, but in the worst case it will be faster!!!
 *                                                         This is a very interesting fact on Java built-in data structure!
 */
public class ArraySplitting {
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
            int n=in.nextInt();
            int k=in.nextInt();
            long [] a=new long[n];
            for(int i=0;i<n;i++)a[i]=in.nextLong();
            long sum=0;
            List<Long> list=new ArrayList<>();

            for(int i=n-1;i>=0;i--){
                sum+=a[i];
                if(i>0)
                    list.add(sum);
            }
            Collections.sort(list, Collections.reverseOrder());
            for(int i=0;i<k-1;i++){
                sum+=list.get(i);
            }

            System.out.println(sum);

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
