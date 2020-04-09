package Implementations;

import java.util.Scanner;

public class RestoringPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int b[] = new int[n];
            for (int i = 0; i < n; i++){
                b[i] = sc.nextInt();
            }
            solve(b, n);
            t--;
        }
    }

    private static void solve(int[] b, int n) {
        boolean[] mark = new boolean[2 * n + 1];
        int[] a = new int[2 * n];
        int i, num;
        for (i = 0; i < n; i++){
            if (!mark[b[i]]){
                a[2 * i] = b[i];
                mark[b[i]] = true;
            }
            else{
                System.out.println(-1);
                return;
            }
        }
        for (i = 1; i <= 2 * n - 1; i += 2){
            for (num = a[i - 1]; num <= 2 * n;  num++){
                if (!mark[num]){
                    mark[num] = true;
                    a[i] = num;
                    break;
                }
            }
            if (a[i] == 0){
                System.out.println(-1);
                return;
            }
        }
        for (i = 0; i < 2 * n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
