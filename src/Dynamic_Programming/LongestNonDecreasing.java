package Dynamic_Programming;

import java.util.Scanner;

public class LongestNonDecreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(LongestNonDecreasingLength(a, -999999, 0));
    }

    private static int LongestNonDecreasingLength(int[] a, int prev, int beg) {
        if (beg == a.length){
            return 0;
        }
        else{
            int r = 0;
            for (int i = beg; i < a.length; i++){
                if (a[i] >= prev){
                    int update = LongestNonDecreasingLength(a, a[i], i + 1) + 1;
                    r = (r > update) ? r : update;
                }
            }
            return r;
        }
    }
}
