package Implementations;
import java.io.*;
import java.util.*;

public class Skier {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }
    private static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for(int j = 0; j < t; j++){
                String s = in.nextToken();
                int l = s.length();
                int cnt = 0;
                // bit mask and hashmap
                Map<Pair, Integer> map = new HashMap();
                int y = 0, x = 0;
                for (int i = 0; i < l; i++){
                    char ch = s.charAt(i);
                    Pair src = new Pair(y, x);
                    int state = map.getOrDefault(src, 0);
                    int mask = 0;
                    if (ch == 'N'){
                        mask = 0;
                        y++;
                    }
                    else if (ch == 'S'){
                        mask = 3;
                        y--;
                    }
                    else if (ch == 'W'){
                        mask = 2;
                        x++;
                    }
                    else{
                        mask = 1;
                        x--;
                    }
                    Pair dest = new Pair(y, x);
                    // put src and dest new state to hash map;
                    map.put(src, state | (1 << mask));
                    int val = map.getOrDefault(dest, 0);
                    if (val == 0 || (val & (1 << (3 - mask))) == 0){
                        cnt += 5;
                    }
                    else{
                        cnt += 1;
                    }
                    map.put(dest, val | (1 << (3 - mask)));
                }
                out.println(cnt);
            }
        }
    }
    static class Pair{
        public int x, y;
        public Pair(int x, int y){
            this.x = x; this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Pair)obj).x && this.y == ((Pair)obj).y;
        }

        @Override
        public int hashCode() {
            return this.x * 100+ this.y;
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
