package Codeforce.div2;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, j;

        int[][] W =  new int[n][n];
        double[][] A = new double[n][n];
        double[][] B = new double[n][n];

        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                W[i][j] = sc.nextInt();

            }
        }

        for (i = 0; i < n; i++){
            B[i][i] = 0; A[i][i] = W[i][i];
            for (j = i + 1; j < n; j++){
                A[i][j] = (double)(W[i][j] + W[j][i]) / 2;
                B[i][j] = W[i][j] - A[i][j];
                A[j][i] = A[j][i];
                B[j][i] = -B[i][j];
            }
        }
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                System.out.print(A[i][j] + "00000000 ");
            }
            System.out.println();
        }
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                System.out.print(B[i][j] + "00000000 ");
            }
            System.out.println();
        }
    }
}
