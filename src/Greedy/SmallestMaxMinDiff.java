package Greedy;

import java.util.Arrays;

public class SmallestMaxMinDiff {
    public static void main(String[] args) {
        int[] A = {0, 10};
        int K = 2;
        System.out.println(smallestRangeII(A, K));
    }
    public static int smallestRangeII(int[] A, int K) {
        int r = Integer.MAX_VALUE;
        int n = A.length;
        Arrays.sort(A);
        K = (K < 0) ? - K : K;
        for (int last_inc = 0; last_inc < n - 1; last_inc++){
            int max =  Math.max(A[n - 1] - K, A[last_inc] + K);
            for (int first_dec = 1; first_dec < last_inc; first_dec++){
                {
                    int min = Math.min(A[first_dec] - K, A[0] + K);
                    r = Math.min(r, max -  min);
                }
            }
            int min = Math.min(A[last_inc + 1] - K, A[0] + K);
            r = Math.min(r, max -  min);
        }
        return Math.min(r, A[n - 1] - A[0]);
    }
}
