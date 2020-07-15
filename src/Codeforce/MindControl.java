package Codeforce.div2;

import java.util.Scanner;

public class MindControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; t++){
            int n = sc.nextInt(); // all numbers
            int m = sc.nextInt(); // your position
            int k = sc.nextInt(); // up to k people
            int arr[] = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(f(arr, m, k));
        }
    }

    private static int f(int[] arr, int m, int k) {
        int n = arr.length, result = Integer.MAX_VALUE;
        int not_obey = Math.max(m - 1 - k, 0);
        for (int left = 0; left <= not_obey; left++){
            // start : i, end : n - (not_obey - i)
            int max = -1;
            int right = (n - 1) - (not_obey - left);
            int obey = Math.min(k, m - 1 - not_obey);
            for (int l = 0; l <= obey; l++){
                max = Math.max(max, Math.max(arr[left + l], arr[right - (obey - l)]));
            }
            result = Math.min(max, result);
        }
        return result;
    }
}
