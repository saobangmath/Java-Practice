package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:  Tran Anh Tai
 */
public class CurrencyExchange {
    static class Edge{
        public int src, dest;
        public double weight;
        public Edge(int src, int dest, double weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class Graph{
        public int V, E;
        public Edge edges[];
        public double dist[];
        public static boolean hasNegLoop = false;
        public Graph(int V, int E){
            this.V = V;
            this.E = E;
            this.edges = new Edge[E];
            this.dist = new double[V];
            Arrays.fill(this.dist, Double.MAX_VALUE);
        }
        void BellmanFord(int src){
            this.dist[src] = 0.0;
            // relax all edges V - 1 times;
            for (int time = 0; time < this.V - 1; time++){
                for (int i = 0; i < this.E; i++){
                    Edge edge = this.edges[i];
                    int u = edge.src;
                    int v = edge.dest;
                    double w =  edge.weight;
                    if (dist[u] != Double.MAX_VALUE &&
                        dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
            // check for negative weight cycle;
            for (int i = 0; i < this.E; i++){
                Edge edge = this.edges[i];
                int u = edge.src;
                int v = edge.dest;
                double w = edge.weight;
                if (dist[u] != Double.MAX_VALUE &&
                   dist[u] + w < dist[v]){
                    hasNegLoop = true;
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
       double[][] exchange =  {{1,0.5,0.2},{2.05,1,0.5},{3.3,1.2,1}};
       assert (currencyArbitrary(exchange));
    }

    static boolean currencyArbitrary(double[][] exchange){
        int n = exchange.length;
        Graph g = new Graph(n, n* (n - 1));
        int cur = 0;
        int i, j;
        for (i = 0; i < n; i++){
            for (j = i + 1; j < n; j++){
                g.edges[cur++] = new Edge(i, j, -Math.log(exchange[i][j]));
                g.edges[cur++] = new Edge(j, i, -Math.log(exchange[j][i]));
            }
        }
        // run BellmanFord algorithm;
        for (int src = 0; src < n; src++){
            g.BellmanFord(src);
            if (g.hasNegLoop){
                return true;
            }
        }
        return false;
    }
}
