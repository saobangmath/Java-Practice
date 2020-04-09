package Competitive_Programming;

import java.util.Scanner;

public class InfinitePrefixes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0 ; z < t; z++){
            int n  = sc.nextInt();
            int x = sc.nextInt();
            String s = sc.next();
            int[] d = new int[n];
            int result = (x == 0) ? 1 :  0;
            d[0] = s.charAt(0) == '0' ? 1 : -1;
            for (int i = 1; i < n; i++){
                d[i] = (s.charAt(i) == '0' ? 1 : -1) + d[i - 1];
            }
            for (int i = 0; i < n; i++){
                int m = x - d[i];
                if (d[n - 1] == 0){
                    if (m == 0){
                        result = -1; break;
                    }
                }
                else{
                    if (m % d[n - 1] == 0 && m /d[n  - 1] >= 0){
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
