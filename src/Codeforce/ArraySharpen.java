package Codeforce.div2;

import java.util.Scanner;

public class ArraySharpen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println((ok(arr) ? "Yes" : "No"));
        }
    }

    private static boolean ok(int[] arr) {
        int n = arr.length, i;
        boolean inc[] = new boolean[n];
        boolean dec[] = new boolean[n];
        inc[0] = dec[n - 1] = true;
        for (i = 1; i < n; i++){
            if (arr[i] >= i){
                inc[i] = true;
            }
            else{
                break;
            }
        }
        for (i = n - 2; i >= 0; i--){
            if (arr[i] >= (n - 1 - i)){
                dec[i] = true;
            }
            else{
                break;
            }
        }
        for (i = 0; i < n; i++){
            if (inc[i] && dec[i]){
                return true;
            }
        }
        return false;
    }
}
