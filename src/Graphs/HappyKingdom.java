package Graphs;

import java.util.*;

public class HappyKingdom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // city
        int k = sc.nextInt(); //industry
        int i;
        List<Integer>[] E = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (i = 0; i < n; i++){
            E[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (i = 0; i < n - 1; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            E[x].add(y); E[y].add(x);
        }
        System.out.println(solve(E, visited));
    }

    private static int solve(List<Integer>[] E, boolean[] visited) {
        return 0;
    }
}
