package Graphs;

import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @Link:https://codeforces.com/contest/1365/problem/D
 * @Key: Try to block all those bad people and see if all the good people is able to escape the maze
 * @Why: As in if any good person MUST pass through any block use to isolate the bad people, either both of them could escaoe through the maze or blocked !!! -> contradition!
 */
public class MazeSolving {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                char[][] maze = new char[n][m];

                ArrayList<Pair> bads = new ArrayList<>();
                ArrayList<Pair> goods =new ArrayList<>();

                boolean[][] visited = new boolean[n][m];
                boolean ok = true;

                for (int j = 0; j < n; j++) {
                    maze[j] = in.nextToken().toCharArray();
                    for (int k = 0; k < m; k++) {
                        char ch = maze[j][k];
                        if (ch == 'B') {
                            bads.add(new Pair(j, k));
                        }
                        if (ch == 'G'){
                            goods.add(new Pair(j, k));
                        }
                    }
                }
                for (Pair bad : bads) {
                    int y = bad.y;
                    int x = bad.x;
                    if (!visited[y][x]) {
                        if (!dfs(y, x, maze, visited)) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (!ok){
                    out.println("No");
                }
                else{
                    dfs2(n - 1, m - 1,maze,  visited);
                    for (Pair good : goods){
                        if (!visited[good.y][good.x]){
                            ok = false;
                            break;
                        }
                    }
                    if (ok){
                        if (maze[n - 1][m - 1] == '#'){
                            ok = (goods.size() == 0);
                        }
                    }
                    if(!ok){
                        out.println("No");
                    }
                    else{
                        out.println("Yes");
                    }
                }
            }
        }

        private void dfs2(int y, int x, char[][] maze, boolean[][] visited){
            int n = visited.length;
            int m = visited[0].length;
            visited[y][x] = true;
            for (int[] dir  : dirs){
                int new_y = y + dir[0];
                int new_x = x + dir[1];
                if (new_y >= 0 && new_x >= 0 && new_y < n && new_x < m
                        &&!visited[new_y][new_x] && maze[new_y][new_x] != '#'){
                    dfs2(new_y, new_x, maze, visited);
                }
            }
        }
        private boolean dfs(int y, int x, char[][] maze, boolean[][] visited) {
            visited[y][x] = true;

            int n = visited.length;
            int m = visited[0].length;

            for (int[] dir : dirs) {
                int new_y = y + dir[0];
                int new_x = x + dir[1];
                if (new_x >= 0 && new_y >= 0 && new_x < m && new_y < n){
                    if (!visited[new_y][new_x]){
                        char ch  = maze[new_y][new_x];
                        if (ch == 'G'){
                            return false;
                        }
                        else if (ch == '.'){
                            maze[new_y][new_x] = '#';
                            visited[new_y][new_x] = true;
                        }
                        else if (ch != '#'){
                            if (!dfs(new_y, new_x, maze, visited)){
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        private class Pair{
            public int y, x;
            public Pair(int y, int x){
                this.x = x;
                this.y = y;
            }
        }
    }
    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}
