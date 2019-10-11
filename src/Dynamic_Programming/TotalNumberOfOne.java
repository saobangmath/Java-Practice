package Dynamic_Programming;

import java.util.Scanner;

public class TotalNumberOfOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countDigitOne(n));
    }
    static int countDigitOne(int n) {
        // r[i] count no of 1 from 0 (x - 1  0) to 9...999 (x 9)
        int[]r = new int[10];
        int in = 1;
        int res = 0;
        String s = n + "";
        for (int i = 1; i < 10; i++){
            r[i] = (int)(Math.pow(10, i - 1));
            for (int j = 0; j < i; j++){
                r[i] += r[j] * 9;
            }
        }
        while ((int)Math.pow(10, in) <= n){
            ++in;
        }
        // no of 1's for every number whose no of digits < no of digits of n
        for (int i = 0; i < in; i++){
            res += r[i];
        }
        int first = s.charAt(0) - '0';
        int count = 0;
        for (char c = 1; c < first;c ++) count++;
        res += count * res;

        return res;
    }
}
