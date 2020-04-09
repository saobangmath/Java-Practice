package Advanced_Data_Structure;

import java.util.Scanner;

public class OnSumOfFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            if (isPrime(n + 1)){
                System.out.println((n - 1) + "/" + (2* (n + 1)));
            }
            else{
                int min = n;
                int max = n + 1;
                while (!isPrime(min)){
                    min--;
                }
                while (!isPrime(max)){
                    max++;
                }
                long det = (long)2 * max * min;
                long nom = (long)1 * max * min - 2 * max + 2 * (n - min + 1);
                System.out.println(nom  + "/" + det);
            }
        }
    }
    public static boolean isPrime(int n){
        int d = (int)(Math.sqrt(n));
        for (int x = 2; x <= d; x++){
            if (n % x == 0){
                return false;
            }
        }
        return true;
    }
}
