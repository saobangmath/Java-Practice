import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 */
public class ProbD {
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
        int N = 100000;
        int[] d = new int[N + 1];
        int[] a = new int[N + 1];
        ArrayList<Integer> pos[] = new ArrayList[N + 1];
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt(); // days
            int m = in.nextInt(); // subjects
            int i;
            for (i = 0; i <= m; i++){
                pos[i] = new ArrayList<>();
            }
            for (i = 1; i <= n; i++){
                d[i] = in.nextInt();
                pos[d[i]].add(i);
            }
            for (i = 1; i <= m;i++){
                a[i] = in.nextInt();
            }
            int end = n;
            int beg = 1;
            if (!pass(end, m)){
                out.println(-1);
            }
            else{
                while (beg < end){
                    int mid = (beg + end) / 2;
                    if (pass(mid, m)){
                        end = mid;
                    }
                    else{
                        beg = mid + 1;
                    }
                }
                out.println(beg);
            }
        }
        static class Slot implements Comparable<Slot>{
            public int no, pos, days;
            public Slot(int no, int pos, int days){
                this.no = no;
                this.pos = pos;
                this.days = days;
            }

            @Override
            public int compareTo(Slot o) {
                if (this.pos > o.pos){
                    return 1;
                }
                else if (this.pos < o.pos){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
        private boolean pass(int end, int m) {
            Slot[] slots = new Slot[m + 1]; // nearest position of a
            boolean ok = true;
            for (int i = 1; i <= m; i++){
                int nearest = binarySearch(i, end);
                if (nearest == -1) {
                    ok = false;
                    break;
                }
                else{
                    slots[i] = new Slot(i, nearest, a[i]);
                }
            }
            if (!ok){
                return false;
            }
            Arrays.sort(slots, 1, m+1);
            int cnt = slots[1].pos - 1;
            int i = 1;
            while (i <= m){
                if (cnt < slots[i].days){
                    ok = false;
                    break;
                }
                else{
                    cnt -= slots[i].days;
                }
                if (i < m){
                    cnt += (slots[i + 1].pos - 1 - slots[i].pos);
                }
                i++;
            }
            assert(cnt >= 0);
            return ok;
        }

        private int binarySearch(int i, int target) {
            int beg = 0;
            int end = pos[i].size() - 1;
            if (end < 0){
                return -1;
            }
            if (target < pos[i].get(beg)){
                return -1;
            }
            else{
                while (beg < end - 1){
                    int mid = (beg + end) / 2;
                    if (pos[i].get(mid) <= target){
                        beg = mid;
                    }
                    else{
                        end = mid - 1;
                    }
                }
                if (pos[i].get(end) <= target){
                    return pos[i].get(end);
                }
                return pos[i].get(beg);
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