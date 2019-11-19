package GoogleKickStart;

import java.util.Scanner;

public class ProbB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == -1){
            System.out.println(-1);
        }
        else if (n == 0){
            System.out.println(0);
        }
        else{
            int max = -1;
            int min = 1000;
            int node = 1;
            int x, y;
            for (int i = 0; i < n + 1; i++){
                x = -1;
                y = -1;
                for (int j = 0; j < node; j++){
                    y = sc.nextInt();
                    if (y == -1){
                        node--;
                    }
                    if (x != -1 && y != -1 && j % 2 == 1){
                        int gcd =  gcd(x, y);
                        max = (max < gcd) ? gcd : max;
                        min = (min > gcd) ? gcd : min;
                    }
                    x = y;
                }
                node = node * 2;
            }
            System.out.println("Max is: " + max + " Min is: " + min);
            if (max == -1 || min == 1000){
                System.out.println(0);
            }
            else{
                System.out.println(max - min);
            }
        }
    }

    private static int gcd(int l, int r) {
        if (l == 0){
            return r;
        }
        else if (l > r){
            return gcd(r, l);
        }
        else{
            return gcd(l, r % l);
        }
    }
}
