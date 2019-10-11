package Greedy;

import java.util.Scanner;

public class LargestRectangle {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0 ; i < n; i++){
            h[i] = sc.nextInt();
        }
        System.out.println(largestRectangle(h));
        sc.close();
    }
    static long largestRectangle(int[] h){

        return 0;
    }
}
