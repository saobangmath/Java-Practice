package Backtracking;

public class ShortestPath {
    private int res;
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        ShortestPath p = new ShortestPath();
        int grid[][]  = {   {0,0,1,0,0,0,0,1,0,1,1,0,0,1,1},
                            {0,0,0,1,1,0,0,1,1,0,1,0,0,0,1},
                            {1,1,0,0,0,0,0,1,0,1,0,0,1,0,0},
                            {1,0,1,1,1,1,0,0,1,1,0,1,0,0,1},
                            {1,0,0,0,1,1,0,1,1,0,0,1,1,1,1},
                            {0,0,0,1,1,1,0,1,1,0,0,1,1,1,1},
                            {0,0,0,1,0,1,0,0,0,0,1,1,0,1,1},
                            {1,0,0,1,1,1,1,1,1,0,0,0,1,1,0},
                            {0,0,1,0,0,1,1,1,1,1,0,1,0,0,0},
                            {0,0,0,1,1,0,0,1,1,1,1,1,1,0,0},
                            {0,0,0,0,1,1,1,0,0,1,1,1,0,1,0}
                        };
        int k = 27;
        System.out.println(p.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        res =  -1;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] mark = new boolean[h][w];
        dfs(grid, mark, k, 0, 0, 0);
        return res;
    }

    public void dfs(int[][]grid, boolean[][] mark, int k, int y, int x, int step){
        mark[y][x] = true;
        int h = grid.length;
        int w = grid[0].length;
        if (step >= res && res != -1){
            mark[y][x] = false;
            return;
        }
        if (y == h - 1 && x == w - 1){
            res = (res == -1) ? step : Math.min(res, step);
            mark[y][x] = false;
            return;
        }
        for (int[] dir : dirs){
            int new_y = y + dir[0];
            int new_x = x + dir[1];
            if (new_y >= 0 && new_y < h && new_x >= 0 && new_x < w && !mark[new_y][new_x]){
                if (grid[new_y][new_x] == 0){
                    dfs(grid, mark, k, new_y, new_x, step + 1);
                }
                else{ //overcome this obstacle;
                    if (k == 0){
                        mark[y][x] = false;
                        return ;
                    }
                    else{
                        dfs(grid, mark, k - 1, new_y, new_x, step + 1);
                    }
                }
            }
        }
        mark[y][x] = false; // reset
    }
}