package Backtracking;

import java.util.Scanner;

public class AmazingBinarySeq {
    //print all binary sequence with exactly 2 '01' -> in form 1..1(a) 0..0(b + 1) 1..1(c + 1) 0...0(d + 1) 1...1 (e + 1) 0...0(f)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 4){
            return;
        }
        n -= 4;
        for (int a = 0; a <= n; a++){
            for(int  b = 0; b <= n - a; b++){
                for (int c = 0; c <= n - a - b; c++){
                    for (int d = 0; d <= n - a - b - c; d++){
                        for (int e = 0; e <= n - a - b - c - d - e; e++){
                            int f = n - a - b - c - d - e;
                            if (f >= 0){
                                display(a, b + 1, c + 1, d + 1, e + 1, f);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void display(int a, int b, int c, int d, int e, int f) {
        int i;
        for (i = 0; i < a; i++){
            System.out.print(1);
        }
        for (i = 0; i < b; i++){
            System.out.print(0);
        }
        for (i = 0; i < c; i++){
            System.out.print(1);
        }
        for (i = 0; i < d; i++){
            System.out.print(0);
        }
        for (i = 0; i < e; i++){
            System.out.print(1);
        }
        for (i = 0; i < f; i++){
            System.out.print(0);
        }
        System.out.println();
    }
}
