package Dynamic_Programming;

import java.util.*;

public class RemoveBoxes {
    // dp[l][r][k]: the result apply for the subarray with left index = l;
    // right index = r and exactly k previous elements has the same color with boxes[l];
    static int[][][] dp = new int[101][101][101];
    public static void main(String[] args) {
        int[] boxes = {1,3,2,2,2,3,4,3,1};
        System.out.println(removeBoxes(boxes));
    }
    public static int removeBoxes(int[] boxes) {
        int i, j;
        int l = boxes.length;
        for (i = 0; i < 101; i++){
            for (j = 0; j < 101; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return process(0, l - 1, 0, boxes);
    }

    private static int process(int left, int right, int prev, int[] boxes) {
        if (right < left){
            return 0;
        }
        if (dp[left][right][prev] != -1){
            return dp[left][right][prev];
        }
        else{
            dp[left][right][prev] = ((prev + 1) * (prev + 1) + process(left + 1, right, 0, boxes));
            int brk;
            for (brk = left + 1; brk <= right; brk++){
                if (boxes[brk] == boxes[left]) {
                    dp[left][right][prev] = Math.max(dp[left][right][prev],
                            process(left + 1, brk - 1, 0, boxes) + process(brk, right, prev + 1, boxes));
                }
            }
            return dp[left][right][prev];
        }
    }
}
