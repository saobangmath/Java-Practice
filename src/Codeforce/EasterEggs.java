package Codeforce.div2;

import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String color = "GBIV";
        int n = sc.nextInt();
        System.out.print("ROYGBIV");
        for (int i = 7; i < n; i++){
            System.out.print(color.charAt((i - 3) % 4));
        }
    }
}
