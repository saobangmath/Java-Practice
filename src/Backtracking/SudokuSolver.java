package Backtracking;

import java.util.HashMap;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][]board = {{'.','.','.','.','.','.','.','5','.'},
                         {'5','.','.','8','.','.','.','.','.'},
                         {'.','4','.','.','1','3','6','.','.'},
                         {'.','6','.','.','5','.','4','8','.'},
                         {'3','.','4','1','.','6','2','.','5'},
                         {'.','5','2','.','.','.','.','1','.'},
                         {'.','.','3','4','8','.','.','9','.'},
                         {'.','.','.','7','.','5','.','.','1'},
                         {'.','2','.','.','.','.','.','.','.'}};
        solve(board,0 ,0);
    }

    public static void solve(char[][] board, int row, int col) {
        if (row == 9){
            display(board);
            return ;
        }
        if (board[row][col] != '.'){
            ++col;
            if (col == 9) {
                ++row;
                col = 0;
            }
            solve(board, row, col);
        }
        else{
            for (char num = '1'; num <= '9'; num++){
                if (checkValid(board, row, col, num)){
                    int new_col = (col + 1 < 9) ? col + 1 : 0;
                    int new_row = (col + 1 < 9) ? row : row + 1;
                    solve(board, new_row, new_col);
                }
                board[row][col] = '.'; // reset
            }
        }
    }

    public static boolean checkValid(char[][] board, int row, int col, char num){
        board[row][col] = num;
        HashMap<Character, Boolean> row_hm = new HashMap<>();
        HashMap<Character, Boolean> col_hm = new HashMap<>();
        HashMap<Character, Boolean> square_hm = new HashMap<>();
        for (char ch = '1'; ch <= '9'; ch++){
            row_hm.put(ch, false);
            col_hm.put(ch, false);
            square_hm.put(ch,false);
        }
        // check row first
        for (int c = 0; c < 9; ++c){
            if (board[row][c] != '.'){
                if  (row_hm.get(board[row][c])){
                    return false;
                }
                else{
                    row_hm.put(board[row][c], true);
                }
            }
        }
        // check col now
        for (int r = 0; r < 9; ++r){
            if (board[r][col] != '.'){
                if  (col_hm.get(board[r][col])){
                    return false;
                }
                else{
                    col_hm.put(board[r][col], true);
                }
            }
        }
        // check square now
        int _x = row - row % 3;
        int _y = col - col % 3;
        for (int x = _x; x <= _x + 2; x++){
            for (int y = _y; y <= _y + 2; y++){
                if (board[x][y] != '.'){
                    if (square_hm.get(board[x][y])){
                        return false;
                    }
                    else{
                        square_hm.put(board[x][y], true);
                    }
                }
            }
        }
        return true;
    }
    public static void display(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }
}
