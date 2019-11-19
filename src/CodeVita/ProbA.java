package CodeVita;

import java.util.Scanner;

public class ProbA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        for (int layer = 1; layer <= n / 2 ; layer++){
            int x = -1, y = -1;
            for (int i = layer - 1; i <=  n - layer; i++){
                if (matrix[0][i] == 'X') {
                    y = 0;
                    x = i;
                    break;
                }
                if (matrix[n - layer][i] == 'X'){
                    y = n - layer;
                    x = i;
                    break;
                }
            }

            for (int j = layer - 1; j <= n - layer; j++){
                if (matrix[j][0] == 'X'){
                    y = j;
                    x = 0;
                    break;
                }
                if (matrix[j][n - layer] == 'X'){
                    y = j;
                    x = n - layer;
                }
            }
            if (x == n - layer || y == 0){
                System.out.print(((x - (layer - 1)) + (y - (layer -  1))) + " ");
            }
            else{
                System.out.println(-((x - (layer - 1)) + (y - (layer -  1)))+ " ");
            }
        }
    }

}
