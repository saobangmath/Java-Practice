package Graphs;

import java.io.*;
import java.util.StringTokenizer;

public class MonopoleMagnetes {
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
    static class Task{
        static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] grid = new char[n][m];
            boolean mark[][] = new boolean[n][m];
            int i, j;
            for (i = 0; i < n; i++){
                String s = in.nextToken();
                for (j = 0; j < m; j++){
                    grid[i][j] = s.charAt(j);
                }
            }

            if (!ok(grid)){
                out.println(-1);
            }
            else{
                int cnt = 0;
                for (i = 0; i < n; i++){
                    for (j = 0; j < m; j++){
                        if (grid[i][j] == '#' &&
                                !mark[i][j]){
                            bfs(i, j, grid, mark);
                            cnt++;
                        }
                    }
                }
                out.println(cnt);
            }
        }

        private void bfs(int y, int x, char[][] grid, boolean[][] mark) {
            int h = mark.length;
            int w = mark[0].length;
            mark[y][x] = true;
            for (int[] dir : dirs){
                int new_y = y + dir[0];
                int new_x = x + dir[1];
                if (new_x >= 0 && new_y >= 0
                        && new_x < w && new_y < h
                        && grid[new_y][new_x] == '#' && !mark[new_y][new_x]){
                    bfs(new_y, new_x, grid, mark);
                }
            }
        }

        private boolean ok(char[][] grid) {
            int h = grid.length;
            int w = grid[0].length;
            int row, col;
            boolean isok = true;
            boolean haswhite = false;
            boolean colNotEmp = true, rowNotEmp = true;
            for (row = 0; row < h; row++){
                col = 0;
                haswhite = false;
                while (col < w && grid[row][col] == '.'){
                    col++;
                }
                if (col == w){
                    colNotEmp = false;
                }
                while (col < w){
                    if (grid[row][col] == '.'){
                        haswhite = true;
                    }
                    else if (haswhite){
                        isok = false;
                        break;
                    }
                    col++;
                }
            }
            for (col = 0; col < w; col++){
                row = 0;
                haswhite = false;
                if (!isok){
                    break;
                }
                while (row < h && grid[row][col] == '.'){
                    row++;
                }
                if (row == h){
                    rowNotEmp = false;
                }
                while (row < h){
                    if (grid[row][col] == '.'){
                        haswhite = true;
                    }
                    else if (haswhite){
                        isok = false;
                        break;
                    }
                    row++;
                }
            }
            if (rowNotEmp ^ colNotEmp){
                isok = false;
            }
            return isok;
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
