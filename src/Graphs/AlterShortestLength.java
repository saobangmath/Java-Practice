package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AlterShortestLength {
    public static class Edge{
        public int src, dest, color;
        public Edge(int src, int dest, int color) {
            this.src = src;
            this.dest = dest;
            this.color = color;
        }
    }
    public static class Graph{
        public int V;
        public ArrayList<Edge>[] edges;
        public HashMap<Edge, Integer> hm;
        public int[][] dist;
        public Graph(int V){
            this.V = V;
            edges = new ArrayList[V];
            for (int i = 0; i < V; i++){
                edges[i] = new ArrayList<Edge>();
            }
            dist = new int[V][2];
            for (int i = 1; i < V; i++){
                Arrays.fill(dist[i], -1);
            }
        }
        public void addEdge(int x, int y, int color){
            edges[x].add(new Edge(x, y, color));
        }
        public void bfs(){
            for (Edge edge : edges[0]){
                int next = edge.dest;
                int color = edge.color;
                dist[next][color] = 1;
                bfsUtil(next, color);
            }
        }
        public void bfsUtil(int src, int cur_color){
            for (Edge edge : edges[src]){
                int color = edge.color;
                int dest = edge.dest;
                if (color != cur_color){
                    if (dist[dest][color] == -1 || dist[dest][color] > dist[src][cur_color] + 1){
                        dist[dest][color] = dist[src][cur_color] + 1;
                        bfsUtil(dest, color);
                    }
                }
            }
        }
    }
    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Graph g = new Graph(n);
        int[] res = new int[n];
        for (int[] x : red_edges){
            g.addEdge(x[0], x[1], 0);
        }
        for (int[] x : blue_edges){
            g.addEdge(x[0], x[1], 1);
        }
        g.bfs();
        for (int i = 1; i < n; i++){
            int d1 = g.dist[i][0];
            int d2 = g.dist[i][1];
            if (d1 == -1){
                res[i] = d2;
            }
            else if (d2 == -1){
                res[i] = d1;
            }
            else{
                res[i] = Math.min(d1, d2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] red_edges = {{0,1},{1,2}};
        int[][] blue_edges = {};
        int[] dist = shortestAlternatingPaths(n, red_edges, blue_edges);
        for (int i = 0; i < n; i++){
            System.out.print(dist[i] + " ");
        }
    }
}
