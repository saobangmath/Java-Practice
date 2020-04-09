package Dynamic_Programming;

import java.util.Scanner;

public class MinimumTriangulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i;
        long res = 0;
        for (i = 2; i <= n - 1; i++){
            res += i * (i + 1);
        }
        System.out.println(res);
    }
}
