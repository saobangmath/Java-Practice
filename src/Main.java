import java.io.BufferedReader;
import java.util.*;
import java.io.*;

/**
 * @author Tran Anh Tai
 */
public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }
    // main solver

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int matrix[][] = new int[m][n];
            int i, j;
            for (i = 0; i < m; i++){
                for (j = 0; j < n; j++){
                    matrix[i][j] = in.nextInt();
                }
            }
            int low_x = 0, low_y = 0;
            int high_x = n - 1, high_y = m - 1;

            while (low_x <= high_x || low_y <= high_y){
                for (int x = low_x; x <= high_x; x++){
                    out.print(matrix[low_y][x]+ " ");
                }
                for (int y = low_y + 1; y <= high_y; y++){
                    out.print(matrix[y][high_x] + " ");
                }
                for (int x = high_x - 1; x >= low_x; x--){
                    out.print(matrix[high_y][x] + " ");
                }
                for (int y = high_y - 1; y >= low_y + 1; y--){
                    out.print(matrix[y][low_x] + " ");
                }
                high_x--; high_y--;
                low_x++; low_y++;
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