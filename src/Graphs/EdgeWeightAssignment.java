package Graphs;

import java.util.*;
public class EdgeWeightAssignment {
    static boolean leaf[] = new boolean[100000];
    static int count[] = new int[100000];
    static boolean visited[]=  new boolean[100000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int max = n - 1, min = 3, src = -1;
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++){
            leaf[i] = true;
            g[i] = new ArrayList<>();
        }
        //O(n)
        for (int i = 0; i < n - 1; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            count[x]++; count[y]++;
            if (count[x] >= 2){
                leaf[x] = false;
            }
            if (count[y] >= 2){
                leaf[y] = false;
            }
            g[x].add(y);
            g[y].add(x);
        }
        //O(n)
        for (int i = 0; i < n; i++){
            if (!leaf[i]){
                int c = 0;
                for (int j : g[i]){
                    if (leaf[j]) c++;
                }
                if (c >  0) {
                    max -= (c - 1);
                }
            }
            else{
                src = i;
            }
        }
        if (noOdd(g, src, 0)){
            min = 1;
        }
        System.out.println(min + " " + max);
    }

    private static boolean noOdd(List<Integer>[] g, int src, int count) {
        if (leaf[src] && count % 2 == 1){
            return false;
        }
        else{
            boolean result = true;
            visited[src] = true;
            for (int dest : g[src]){
                if (!visited[dest] && !noOdd(g, dest, count + 1)){
                    result = false;
                    break;
                }
            }
            visited[src] = false;
            return result;
        }
    }
}
