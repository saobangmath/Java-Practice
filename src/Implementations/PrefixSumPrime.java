package Implementations;

import java.util.Scanner;

public class PrefixSumPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int two = 0, one = 0;
        int n = sc.nextInt();
        int i, num;
        for (i = 0; i < n; i++){
            num = sc.nextInt();
            if (num == 2){
                two++;
            }
            else{
                one++;
            }
        }
        boolean stopbyone = false;
        if (two > 0){
            System.out.print(2 + " ");
            two--;
        }
        if (one > 0 &&one % 2 == 0){
            stopbyone = true;
            one--;
        }
        for(i = 0; i < one; i++){
            System.out.print(1 + " ");
        }
        for (i = 0; i < two; i++){
            System.out.print(2 + " ");
        }
        if (stopbyone){
            System.out.println(1);
        }
    }
}
