package CodeVita;

import java.util.ArrayList;
import java.util.Scanner;

public class ProbC {
    public  static class Graph{
        int V, connected, roads;
        ArrayList<Integer>E[];
        boolean mark[];
        public Graph(int V){
            this.V = V;
            this.E = new ArrayList[V];
            this.mark =  new boolean[V];
            for (int i = 0; i < V; i++){
                this.E[i] = new ArrayList<>();
            }
            this.connected = 0;
            this.roads = 0;
        }
        public void addEdge(int x, int y){
            this.E[x].add(y);
            this.E[y].add(x);
        }
        public void bfsUtil(int src){
            this.connected++;
            this.mark[src] = true;
            for (int dest : this.E[src]){
                if (!mark[dest]){
                    bfsUtil(dest);
                }
            }
        }
        public void bfs(){
            for (int src = 0; src < this.V; src++){
                if (!this.mark[src]){
                    bfsUtil(src);
                    this.roads += (this.connected) * (this.connected - 1) / 2;
                    this.connected = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Graph g = new Graph(N);
        for (int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x - 1, y - 1);
        }
        g.bfs();
        System.out.println(g.roads - M);
    }
}
