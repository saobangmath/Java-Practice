package Backtracking;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int i, count = 1, result = 1, cur;
        for (i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        i = 1; cur = a[0];
        while (i < n){
            if (a[i] <= 2 * cur){
                count++;
            }
            else{
                result = Math.max(result, count);
                count = 1;
            }
            cur = a[i++];
        }
        result = Math.max(result, count);
        System.out.println(result);
    }
}
