package Graphs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ConcurrentNavigableMap;

public class shortestPathWithEdge {
    private static int CONST = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int start = 1;
        int end = 4;
        int weight = 2;
        int[][] graph = {{0, 2, 0, 4, 0},
                         {2, 0, 1, 0, 0},
                         {0, 1, 0, 3, 0},
                         {4, 0, 3, 0, 1},
                         {0, 0, 0, 1, 0}};
        System.out.println(shortestPathWithEdge(start, end, weight, graph));
    }
    static int shortestPathWithEdge(int start, int end, int weight, int[][] g){
        int n = g.length;
        boolean m[] = new boolean[n];
        int[] dist = new int[n];
        for (int i = 0; i < n; i++){
            dist[i] = CONST;
        }
        dist[start - 1] = 0;
        dfs(start - 1, end - 1, weight, g, m, dist);
        return dist[end - 1];
    }
    // possible to add new edge with weight
    private static void dfs(int start, int end, int weight, int[][] g, boolean[] m, int[] dist) {
        if (start == end){
            return;
        }
        else{
            int n = m.length;
            m[start] = true;
            for (int dest = 0; dest < n; dest++){
                if (!m[dest]){
                    if (g[start][dest] > 0 && g[start][dest] + dist[start] <= dist[dest]){ // connected
                        dist[dest] = dist[start] + g[start][dest];
                        dfs(dest, end, weight, g, m, dist);
                    }
                    else if (g[start][dest] == 0 && dist[start] + weight <= dist[dest]){ // not connected
                        dist[dest] = weight + dist[start];
                        au_dfs(dest, end, g, m, dist);
                    }
                }
            }
            m[start] = false;
        }
    }
    // without any added each
    private static void  au_dfs(int start, int end, int[][] g, boolean[] m, int[] dist){
        if (start == end){
            return;
        }
        else{
            int n = m.length;
            m[start] = true;
            for (int dest = 0; dest < n; dest++){
                if (!m[dest] && g[start][dest] > 0 && g[start][dest] + dist[start] <= dist[dest]){ // connected
                    dist[dest] = dist[start] + g[start][dest];
                    au_dfs(dest, end, g, m, dist);
                }
            }
            m[start] = false;
        }
    }
}
