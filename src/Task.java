import java.util.*;
/// need to clean too much codes

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        // 0: max without telepot;
        // 1: max in general;
        long[][][] dp = new long[n][m][2];
        int y, x;
        long result = -1;
        for (y = 0; y < n; y++){
            for (x = 0; x < m; x++){
                board[y][x] = sc.nextInt();
                dp[y][x][0] = dp[y][x][1] = -1;
            }
        }
        // for those in the last row
        for (y = 0; y < n; y++){
            if (board[y][m - 1] != -1){
                dp[y][m - 1][0] = board[y][m - 1];
                int sig = 0;
                int up = (y - 1 + n) % n, down = (y + 1 + n) % n;
                long up_sum = board[y][m - 1], down_sum = board[y][m - 1];
                // up sum
                while (up !=  y && board[up][m - 1] != -1){
                    if (up == n - 1){
                        sig = 1;
                        up_sum = 0;
                    }
                    up_sum += board[up][m - 1];
                    dp[y][m - 1][sig] = Math.max(dp[y][m - 1][sig], up_sum);
                    dp[y][m - 1][1] = Math.max(dp[y][m - 1][sig], dp[y][m - 1][1]);
                    up = (up - 1 + n) % n;
                }
                sig = 0;
                // down sum
                while (down != y && board[down][m - 1] != -1){
                    if (down == 0){
                        sig = 1;
                        down_sum = 0;
                    }
                    down_sum += board[down][m - 1];
                    dp[y][m - 1][sig] = Math.max(dp[y][m - 1][sig], down_sum);
                    dp[y][m - 1][1] = Math.max(dp[y][m - 1][sig], dp[y][m - 1][1]);
                    down = (down + 1 + n) % n;
                }
            }
        }
        // dp for those in middle
        for (x = m - 2; x >= 0; x--){
            for (y = 0; y < n; y++){
                if (board[y][x] != -1){
                    int sig = 0;
                    // do directly to the next row.
                    if (dp[y][x + 1][sig] != -1){
                        dp[y][x][sig] = dp[y][x + 1][0] + board[y][x];
                    }
                    int up = (y - 1 + n) % n, down = (y + 1 + n) % n;
                    long up_sum = board[y][x], down_sum = board[y][x];
                    // up sum
                    while (up !=  y && board[up][x] != -1){
                        if (up == n - 1){
                            up_sum = 0;
                            sig = 1;
                        }
                        up_sum += board[up][x];

                        if (sig == 0 && dp[up][x + 1][0] != -1){
                           dp[y][x][0] = Math.max(dp[y][x][0],  dp[up][x + 1][0] + up_sum);
                        }
                        dp[y][x][1] = Math.max(dp[y][x][0], dp[up][x + 1][1]);
                        dp[y][x][1] = Math.max(dp[y][x][1], dp[n - 1][x + 1][1]);

                        up = (up - 1 + n) % n;
                    }
                    sig = 0;
                    // down sum
                    while (down != y && board[down][x] != -1){
                        if (down == 0){
                            down_sum = 0;
                            sig = 1;
                        }
                        down_sum += board[down][x];

                        if (sig == 0 && dp[down][x + 1][0] != -1){
                            dp[y][x][0] = Math.max(dp[y][x][0],  dp[down][x + 1][0] + down_sum);
                        }
                        dp[y][x][1] = Math.max(dp[y][x][0], dp[down][x + 1][1]);
                        dp[y][x][1] = Math.max(dp[y][x][1], dp[0][x][1]);

                        down = (down + 1 + n) % n;
                    }
                }
            }
        }
        for (y = 0; y < n; y++){
            result = Math.max(result, dp[y][0][1]);
        }
        System.out.println(result);
    }
}
