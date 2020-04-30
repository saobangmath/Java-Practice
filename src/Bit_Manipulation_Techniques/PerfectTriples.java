package Bit_Manipulation_Techniques;

import java.util.*;

public class PerfectTriples {
    public static String[] first = new String[]{"00", "01","10", "11"};
    public static String[] second = new String[]{"00", "10", "11", "01"};
    public static String[] third = new String[]{"00", "11", "01", "10"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            long n = sc.nextLong();
            System.out.println(solve(n));
        }
    }

    private static long solve(long n) {
        if (n <= 3){
            return n;
        }
        else{
            String s = "";
            n -= 3;
            long r = 1;
            int blk = 0;
            while (r < n){
                blk++; r = r * 4;
            }
            blk--; r = r / 4;
            if (n % 3 == 0){
                n = n / 3;
                s += "11";
                while (n >= 4){
                    int d = (int)(n / r);
                    s += third[d];
                    n = n % r;
                    r = r / 4;
                }
                s += third[(int)n];
            }
            else if (n % 3 == 1){
                n = n / 3;
                s += "01";
                while (n >= 4){
                    int d = (int)(n / r);
                    s += first[d];
                    n = n % r;
                    r = r / 4;
                }
                s += first[(int)n];
            }
            else if (n % 3 == 2){
                n = n / 3;
                s += "10";
                while (n >= 4){
                    int d = (int)(n / r);
                    s += second[d];
                    n = n % r;
                    r = r / 4;
                }
                s += second[(int)n];
            }
            return Long.parseLong(s, 2);
        }
    }
}
