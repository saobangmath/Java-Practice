package Greedy;

import java.util.Scanner;

public class LoveNines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int r = n % 9;
        System.out.println(MinimumNumber(n));

    }

    private static int MinimumNumber(int n) {
        int r = (n % 10);
        return (n < 9 * (9 - r)) ? -1: 10 - r;
    }
}
