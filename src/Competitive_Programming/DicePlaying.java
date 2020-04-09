package Competitive_Programming;

import java.util.Scanner;

public class DicePlaying {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int win = 0, draw = 0, lose = 0;
        for (int i = 1; i <= 6; i++){
            int _a = Math.abs(a - i);
            int _b = Math.abs(b - i);
            if (_a == _b) draw++;
            else if (_a > _b) lose++;
            else lose++;
        }
        System.out.println(win +" " + draw + " " + lose);
    }
}
