package Competitive_Programming;

import java.util.Scanner;

public class DominoesForYoung {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] col = new int[n];
        long white = 0, black = 0, add;
        boolean w = true;
        for (int i = 0; i < n; i++){
            col[i] = sc.nextInt();
            if (w){
                add = (((col[i] % 2 == 0) ? 0 : 1) + col[i] / 2);
            }
            else{
                add = (col[i] / 2);
            }
            white += add;
            black += (col[i] - add);
            w = !w;
        }
        System.out.println(Math.min(black, white));
    }
}
