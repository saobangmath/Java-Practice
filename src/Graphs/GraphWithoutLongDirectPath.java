package Graphs;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class GraphWithoutLongDirectPath {
    public static class Pair{
        public int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof Pair && (this.x == ((Pair)obj).x) && (this.y == ((Pair)obj).y));
        }

        @Override
        public int hashCode() {
            return (this.x + this.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int i;
        List<Integer>[] E = new ArrayList[n];
        int[] color = new int[n];
        Pair[] edges = new Pair[m];
        Map<Pair, Integer> hm = new HashMap<>();

        for (i = 0; i < n; i++){
            E[i] = new ArrayList<>();
            color[i] = -1;
        }

        for (i = 0; i < m; i++){
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]) - 1;
            int y = Integer.parseInt(xy[1]) - 1;
            E[x].add(y); E[y].add(x);
            hm.put(new Pair(x, y), 0);
            edges[i] = new Pair(x, y);
        }
        color[0] = 0;
        if (dfs(E, color, hm, 0, 0)){
            System.out.println("YES");
            for (Pair p : edges){
                System.out.print(hm.get(p));
            }
        }
        else{
            System.out.println("NO");
        }
    }

    private static boolean dfs(List<Integer>[] E, int[] color, Map<Pair, Integer> hm, int src, int direction) {
        for (int dest : E[src]){
            if (color[dest] == color[src]){
                return false;
            }
            else if (color[dest] == -1){ // not pass through;
                color[dest] = 1 - color[src];
                Pair p = new Pair(src, dest);
                if (direction == 1){
                    if (hm.getOrDefault(p, -1) == -1){ // no have
                        hm.put(new Pair(dest, src), 1);
                    }
                    else{
                        hm.put(p, 0);
                    }
                }else{
                    if (hm.getOrDefault(p, -1) != -1){
                        hm.put(p, 1);
                    }
                    else{
                        hm.put(new Pair(dest, src), 0);
                    }
                }
                if (!dfs(E, color, hm, dest, 1 - direction)){
                    return false;
                }
            }
        }
        return true;
    }
}
