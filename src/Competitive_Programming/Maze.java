package Competitive_Programming;

import java.util.*;

public class Maze {
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static class P{
        public int x, y;
        public P(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x, y, _x = -1, _y = -1;
        char maze[][] = new char[n][m];
        boolean mark[][] = new boolean[n][m];

        for (y = 0; y < n; y++){
            String s = sc.next();
            for (x = 0; x < m; x++){
                maze[y][x] = s.charAt(x);
                if (maze[y][x] == '.'){
                    _x = x; _y = y;
                }
            }
        }
        Queue<P> q = new LinkedList<>();
        List<P> l = new ArrayList<>();

        if (_x != -1){
            q.add(new P(_y, _x));
            while (!q.isEmpty()){
                P pair = q.remove();
                mark[pair.y][pair.x] = true;
                l.add(pair);
                for (int[] dir : dirs){
                    int new_y = pair.y + dir[0];
                    int new_x = pair.x + dir[1];
                    if (new_y >= 0 && new_y < n && new_x >= 0 && new_x < m){
                        if (!mark[new_y][new_x] && maze[new_y][new_x] == '.'){
                            mark[new_y][new_x] = true;
                            q.add(new P(new_y, new_x));
                        }
                    }
                }
            }
        }
        int u = l.size();
        for (int t = u - 1; t >= u - k; t--){
            maze[l.get(t).y][l.get(t).x] = 'X';
        }
        for (y = 0; y < n; y++){
            for (x = 0; x < m; x++){
                System.out.print(maze[y][x]);
            }
            System.out.println();
        }
    }
}
