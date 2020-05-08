package Implementations;

import java.util.Scanner;

public class BusesAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        if ((int)(Math.ceil((double)n / k)) > d +  1){
            System.out.println(-1);
        }
        else{
            int i, j, time;
            for (time = 0; time < d - 1; time++){
                for (i = 0; i < n; i++){
                    System.out.print(((i % k) + 1)+ " ");
                }
                System.out.println();
            }
            for (i = 1; i <= k - 1; i++) {
                for (j = 0; j < k; j++){
                    System.out.print(i + " ");
                }
            }
            for (j = 0; j < n % k; j++){
                System.out.print(k + " ");
            }
        }
    }
}
