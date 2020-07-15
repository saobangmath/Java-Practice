package Codeforce.div2;

import java.util.Scanner;

public class BlockedPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n == 0){
            System.out.println(1);
        }
        System.out.println(4 * (long)Math.floor(n * Math.sqrt(2)));
    }
}
