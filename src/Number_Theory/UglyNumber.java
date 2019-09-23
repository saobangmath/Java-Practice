package Number_Theory;

import java.util.Scanner;

public class UglyNumber {
    public static long gcd(long a, long b){
        if (b == 0){
            return a;
        }
        return (a > b) ? gcd(a % b, b) : gcd(b, a);
    }
    public static long lcm(long a, long b){
        return (a * b) / gcd(a,b);
    }
    public static boolean check(int num, int a, int b, int c){
        return (num % a == 0) || (num % b == 0) || (num % c ==0);
    }
    public static int nthUglyNumber(int n, int a, int b, int c){
        int beg = 1;
        int end = 2000000000;
        long x = lcm(a,b);
        long y = lcm(b,c);
        long z = lcm(a,c);
        long m = lcm(x,c);
        while (beg < end){
            int num = (beg + end) / 2;
            long t =  (num / a) + (num / b) + (num / c) - (num / x) - (num / y) - (num / z) + (num / m);
            if ((int)t < n){
                beg = num + 1;
            }
            else{
                end = num;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(nthUglyNumber(n,a,b,c));
    }
}
