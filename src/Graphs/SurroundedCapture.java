package Graphs;

public class SurroundedCapture {
    public static void main(String[] args) {
        char [][] board = {{'X', 'X', 'X', 'X'},
                           {'X', 'O', 'O', 'X'},
                           {'X', 'X', 'O', 'X'},
                           {'X', 'O', 'X', 'X'}};
        solve(board);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void solve(char[][] board){
        int h = board.length;
        int w = board[0].length;
        boolean[][] mark = new boolean[h][w];
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if (!mark[i][j] && board[i][j] == 'O'){
                    dfs(board, i, j, mark);
                }
            }
        }
    }
    public static boolean dfs(char[][] board, int y, int x, boolean[][] mark){
        boolean result = true;
        int h = board.length;
        int w = board[0].length;
        if (y == h - 1 || y == 0 || x == 0 || x == w - 1){
            result = false;
        }
        mark[y][x] = true;
        for (int[] dir : dirs){
            int _y = y + dir[0];
            int _x = x + dir[1];
            if (_y  >= 0 && _y < h && _x >= 0 && _x < w){
                if (!mark[_y][_x] && board[_y][_x] == 'O'){
                    boolean au = dfs(board, _y, _x, mark);
                    if (!au) result = false;
                }
            }
        }
        if (result){
            board[y][x] = 'X';
        }
        return result;
    }
}
