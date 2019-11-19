package Graphs;
/* Dijkstra for matrix base graph g */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 9;
        int graph[][] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        boolean mark[] = new boolean[V];
        int dist[] = new int[V];
        int parent[] = new int[V];
        int src = 0;
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        Dijkstra(graph, dist, mark, parent, src);
        printDist(V, dist);
        for (int i = 0; i < V; i++){
            printPath(parent, i);
            System.out.println();
        }
    }

    private static void printPath(int[] parent, int i) {
        if (parent[i] != -1) {
            printPath(parent, parent[i]);
            System.out.print("->");
        }
        System.out.print(i);
    }

    public static void printDist(int V, int[] dist){
        System.out.println("Node: " + "      " + "Mininum distance: ");
        for (int i = 0; i < V; i++){
            System.out.println(i +  "         " + dist[i]);
        }
    }
    public static void printParent(int parent[], int src){
        if (parent[src] == -1){
            System.out.print(src);
        }
        else{
            printParent(parent, parent[src]);
            System.out.print("->" + src);
        }
    }
    public static int minIndex(boolean mark[], int dist[]){
        int min_dist = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < mark.length; i++){
            if (!mark[i] && dist[i] <  min_dist){
                min_dist = dist[i];
                index = i;
            }
        }
        return index;
    }
    public static void Dijkstra(int[][] g, int[] dist, boolean[] mark, int parent[], int src){
        dist[src] = 0;
        for (int count = 0; count < mark.length - 1; count++){
            int next = minIndex(mark, dist);
            mark[next] = true;
            for (int vertex = 0; vertex < mark.length; vertex++){
                if (!mark[vertex] && g[next][vertex] != 0 && dist[vertex] > dist[next] + g[next][vertex]){
                    dist[vertex] = dist[next] + g[next][vertex];
                    parent[vertex] = next;
                }
            }
        }
    }
}
