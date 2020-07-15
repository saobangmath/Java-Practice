package Codeforce.div2;

import java.io.*;
import java.util.*;

public class WeightDistribution {
    static long[] p = new long[200000];
    public static void main(String[] args) throws Exception{
        InputStream in = System.in;
        OutputStream out = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter pw = new PrintWriter(out);
        int t = Integer.parseInt(br.readLine());
        for (int x = 0; x < t; x++){
            int i;
            String[] nmabc = br.readLine().split(" ");
            String[] s = br.readLine().split(" ");
            // n, m, a, b, c
            int n = Integer.parseInt(nmabc[0]);
            int m = Integer.parseInt(nmabc[1]);
            int a = Integer.parseInt(nmabc[2]) - 1;
            int b = Integer.parseInt(nmabc[3]) - 1;
            int c = Integer.parseInt(nmabc[4]) - 1;
            // the graph g;
            ArrayList<Integer>[] E = new ArrayList[n];
            // distance from a, b, c to other points;
            int[] da = new int[n];
            int[] db = new int[n];
            int[] dc = new int[n];
            // p[i] input;
            for (i = 0; i < n; i++){
                E[i] = new ArrayList<>();
                da[i] = -1;
                db[i] = -1;
                dc[i] = -1;
            }
            for (i = 0; i < m; i++){
                p[i] = Long.parseLong(s[i]);
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]) - 1;
                int v = Integer.parseInt(uv[1]) - 1;
                E[u].add(v); E[v].add(u);
            }
            Arrays.sort(p,0, m);
            // prefix sum for the array p[i];
            for (i = 1; i < m; i++){
                p[i] = p[i - 1] + p[i];
            }
            // breath first search to find the shortest unit  distance from a, b, c -> very other points.
            bfs(E, a, da);
            bfs(E, b, db);
            bfs(E, c, dc);
            // print the minimum distribution cost
            // assume that there are 3 non - intersect part from a -> x, b -> x, c -> x;
            // then (a -> b) + (b -> c)  = (a -> x) + 2 * (b -> x) + (c -> x)
            // (a -> x), (b -> x), (c -> x) is the shortest unit distance from a->x, .... respectively
            // obviously, the (b -> x) part should assign to be minimum value.
            long result = Long.MAX_VALUE;
            for (i = 0; i < n; i++){
                if (da[i] + db[i] + dc[i] - 1 < m){
                    long part1 = (db[i] - 1 < 0) ? 0 : p[db[i] - 1];
                    long part2 = (da[i] + db[i] + dc[i] - 1 >= 0 ? p[da[i] + db[i] + dc[i] - 1] : 0);
                    long au = part1 + part2;
                    result = Math.min(result, au);
                }
            }
            pw.println(result == Long.MAX_VALUE ?  0 : result);
        }
        pw.close();
        br.close();
    }

    private static void bfs(ArrayList<Integer>[] E, int src, int dist[]) {
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()){
            int top = q.remove();
            for (int dest : E[top]){
                if (dist[dest] == -1 || dist[dest] > dist[top] + 1){
                    dist[dest] = dist[top] + 1;
                    q.offer(dest);
                }
            }
        }
    }
}
