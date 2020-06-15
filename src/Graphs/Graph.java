package Graphs;

import java.util.*;

/**
 * set of all Algorithm related to Graph theory as well as clearly testing
 * @Author: I_love_Tumi
 */
public class Graph {
    int V;
    ArrayList<Integer>[] E;
    boolean visited[];
    static int Vertexes = 4;
    public Graph(int V){
        this.V = V;
        this.E = new ArrayList[V];
        this.visited = new boolean[V];
        for (int i = 0; i < V; i++){
            this.E[i] = new ArrayList<>();
        }
    }
    public void addEdge(int src, int dest){
        this.E[src].add(dest);
    }

    /**
     * Utility function;
     * @param src
     * @param colors
     * @param color
     * @return whether could be color the vertices to be in bipartile;
     */
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

    /**
     * created a new directed graph by reverse the edges of the initial graph
     * @return a created Graph object
     */
    public Graph getTranspose(){
        Graph transpose = new Graph(this.V);
        for (int i = 0; i < this.V; i++){
            for (int dest : this.E[i]){
                transpose.addEdge(dest, i);
            }
        }
        return transpose;
    }

    /**
     * Utility function to construct a stack of graph traversal from a source vertice
     * @param src
     * @param stack
     */
    void fillOrder(int src, Stack<Integer> stack){
        this.visited[src] = true;
        for (int dest : this.E[src]){
            if (!this.visited[dest])
                fillOrder(dest, stack);
        }
        stack.push(src);
    }

    /**
     * utility function to display the list of all Strongly connected component in the graph;
     * @Link:https://www.geeksforgeeks.org/strongly-connected-components/
     * The algorithm using is the Kosaraju algorithm to find all the strongly connected components in the graph
     */
    void printAllSCC(){
        Graph g = this.getTranspose();
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(this.visited, false);
        for (int src = 0; src < this.V; src++){
            if (!visited[src]){
                fillOrder(src, stack);
            }
        }
        while (!stack.isEmpty()){
            int top = stack.peek();
            stack.pop();
            if (!g.visited[top]){
                g.dfs(top);
                System.out.println();
            }
        }
    }

    private void dfs(int top) {
        this.visited[top] = true;
        System.out.print(top + " ");
        for (int dest : this.E[top]){
            if (!this.visited[dest]){
                dfs(dest);
            }
        }
    }

    public static void main(String[] args) {
        // testing on the bipartile;
        Graph g1 = new Graph(Vertexes);
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        for (int[] edge : edges){
            g1.addEdge(edge[0], edge[1]);
            g1.addEdge(edge[0], edge[1]);
        }
        System.out.println(g1.isBiPartile() ? "The graph is bipartial": "The graph is not bipartial");
        // testing on the strongly connected component;
        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        System.out.println("strongly connected components in the graph");
        g2.printAllSCC();
    }
}
