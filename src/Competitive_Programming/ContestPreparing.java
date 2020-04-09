package Competitive_Programming;

import java.util.Scanner;

public class ContestPreparing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int a[] = new int[m];
        int b[] = new int[n];
        int c[] = new int[n];
        int i;
        for (i = 0; i < m; i++){
            a[i] = sc.nextInt();
        }
        for (i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        for (i = 0; i < n; i++){
            c[i] = sc.nextInt();
        }

    }
}
