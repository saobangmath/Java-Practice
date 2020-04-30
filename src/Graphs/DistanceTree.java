package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistanceTree{
    static int[] dp = new int[200000];
    static class VertexComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if (dp[o1] < dp[o2]){
                return 1;
            }
            else if (dp[o1] > dp[o2]){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // Fast IO implementations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i, count = 0;

        List<Integer> E[] = new ArrayList[n];
        boolean visited[] = new boolean[n];
        int par[] = new int[n];


        PriorityQueue<Integer> pq = new PriorityQueue(new VertexComparator());

        for (i = 0; i < n; i++){
            E[i] = new ArrayList<>();
            dp[i] = 0;
        }
        // pre-processing.
        for (i = 0; i < n - 1; i++){
            String[] token = br.readLine().split(" ");
            int x = Integer.parseInt(token[0]) - 1;
            int y = Integer.parseInt(token[1]) - 1;
            E[x].add(y);E[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        // BFS queue
        while (!q.isEmpty()){
            int top = q.remove();
            visited[top] = true;
            for (int dest : E[top]){
                if (!visited[dest]){
                    par[dest] = top;
                    dp[dest] = dp[top] + 1;
                    q.add(dest);
                    if (dp[dest] >= 3){
                        pq.offer(dest);
                    }
                }
            }
        }
        Arrays.fill(visited, false);
        // remove those with longest distance ton the root 1 first.
        while (!pq.isEmpty()){
            int top = pq.remove();
            int parent = par[top];
            if (!visited[top]){
                visited[parent] = true;
                for (int dest : E[parent]){
                    visited[dest] = true;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
