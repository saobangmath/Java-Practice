package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tran Anh Tai
 * Problem 3 in Hackerrank interview Asia.
 * The problem conclusion: Let an indirect graph. What is the minimum distance from (0, 0) -> (n - 1, m - 1);
 */
public class MinimumCost {
    static int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static class Edge{
        int src, dest, weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest= dest;
            this.weight = weight;
        }
    }
    public static class Graph{
        public int V;
        public ArrayList<Edge> edges[];
        public int dist[];
        public Graph(int V){
            this.V = V;
            this.edges = new ArrayList[V];
            this.dist = new int[V];
            for (int i = 0; i < V; i++){
                this.edges[i] = new ArrayList<>();
                this.dist[i] = Integer.MAX_VALUE;
            }
        }
        public void addEdge(int u, int v, int w){
            this.edges[u].add(new Edge(u, v, w));
            this.edges[v].add(new Edge(v, u, w));
        }
        public void Dijkstra(int src){
            PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparable());
            pq.offer(src);
            dist[src] = 0;
            while (!pq.isEmpty()){
                int top = pq.poll();
                for (Edge edge : edges[top]){
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if (dist[dest] == Integer.MAX_VALUE || dist[dest] > dist[src] + weight){
                        dist[dest] = dist[src] + weight; // updated distance;
                        pq.offer(dest);
                    }
                }
            }
        }
        public class CustomComparable implements Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2) {
                if (dist[o1] > dist[o2]){
                    return 1;
                }
                else if (dist[o1] < dist[o2]){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 2},
                        {2, 5, 1, 3},
                        {5, 3, 4, 2},
                        {1, 2, 3, 4}};
        System.out.println(solve(grid));;
    }

    private static int solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Graph g = new Graph(m * n);
        for (int i= 0 ; i  <n; i++){
            for (int j = 0; j < m; j++){
                for (int dir[] : dirs){
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];
                    int x = i * m + j;
                    int y = new_i * m + new_j;
                    if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m){
                        int weight = Math.min(grid[i][j], grid[new_i][new_j]);
                        g.addEdge(x, y, weight);
                        g.addEdge(y, x, weight);
                    }
                }
            }
        }
        g.Dijkstra(0);
        return g.dist[m * n - 1];
    }
}
