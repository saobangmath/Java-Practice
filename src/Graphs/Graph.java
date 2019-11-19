package Graphs;

import java.util.*;

/**
 * set of all Algorithm related to Graph theory as well as clearly testing
 * @Author: I_love_Tumi
 */
public class Graph {
    int V;
    ArrayList<Integer>[] E;
    static int Vertexes = 4;
    public Graph(int V){
        this.V = V;
        this.E = new ArrayList[V];
        for (int i = 0; i < V; i++){
            this.E[i] = new ArrayList<>();
        }
    }
    public void addEdge(int src, int dest){
        this.E[src].add(dest);
        this.E[dest].add(src);
    }
    public boolean isBiPartileUtil(int src, int[]colors, int color){
        colors[src]  = color;
        boolean res = true;
        for (int dest : this.E[src]){
            if (colors[dest] == -1){ // not readch yet
                res = res | isBiPartileUtil(dest, colors, 1 - color);
            }
            else if (colors[dest] == color){
                res = false;
                break;
            }
        }
        return res;
    }
    public boolean isBiPartile(){
        int[] colors = new int[this.V];
        Arrays.fill(colors, -1);
        for (int src = 0; src < this.V; src++){
            if (colors[src] == -1 && !isBiPartileUtil(src, colors, 0)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Graph g = new Graph(Vertexes);
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        for (int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }
        System.out.println(g.isBiPartile() ? "The graph is bipartial": "The graph is not bipartial");
    }
}
