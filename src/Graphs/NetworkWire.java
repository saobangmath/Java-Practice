package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkWire {
    static class edge_comparator implements Comparator<int[]> {
        public int compare(int[] w1, int[] w2)
        {
            return (w1[2] > w2[2] ? 1 : -1);
        }
    }

    static int networkWires(int n, int[][] wires){
        ArrayList<int[]> E[] = new ArrayList[n];
        boolean[] mark = new boolean[n];
        int[] root = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++){
            E[i] = new ArrayList<>();
            root[i] = -1;
        }
        for (int[] wire : wires){
            E[wire[0]].add(wire);
            E[wire[1]].add(wire);
        }
        for (int src = 0; src < n; src++){
            PriorityQueue<int[]> edges = new PriorityQueue(new edge_comparator());
            if (!mark[src]){
                dfs(src, E, mark, edges);
            }
            while (!edges.isEmpty()){
                int[] edge = edges.remove();
                int r_x = find_root(edge[0], root);
                int r_y = find_root(edge[1], root);
                if (r_x != r_y){
                    root[r_x] = r_y;
                    result += edge[2];
                }
            }
        }
        return result;
    }

    public static int find_root(int src, int[] root){
        if (root[src] == -1){
            return src;
        }
        else{
            return find_root(root[src], root);
        }
    }

    private static void dfs(int src, ArrayList<int[]>[] E, boolean[] mark, PriorityQueue<int[]> edges) {
        mark[src] = true;
        for (int[] edge : E[src]){
            edges.add(edge);
            int u = edge[0];
            int v = edge[1];
            if (u != src && !mark[u]){
                dfs(u, E, mark, edges);
            }
            else if (!mark[v]){
                dfs(v, E, mark, edges);
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] wires = {{8,4,23},
                        {8,0,16},
                        {8,2,15},
                        {8,3,76},
                        {4,9,38},
                        {2,6,65},
                        {3,7,83},
                        {9,1,7},
                        {1,5,45},
                        {9,8,78},
                        {4,6,78},
                        {6,9,58},
                        {8,5,87},
                        {5,9,93},
                        {1,6,51},
                        {7,9,28},
                        {1,3,77},
                        {3,0,5},
                        {2,3,86},
                        {3,6,62},
                        {6,7,67},
                        {0,7,80},
                        {2,4,70},
                        {0,4,21},
                        {1,0,52},
                        {7,5,49},
                        {1,4,9},
                        {0,5,85},
                        {2,9,45},
                        {6,8,52},
                        {3,4,59},
                        {2,0,63}};
        System.out.println(networkWires(n, wires));
    }
}
