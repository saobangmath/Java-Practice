package Advanced_Data_Structure;

import java.util.Scanner;

public class CorruptionAndNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, n, l, r;
        for (i = 0; i < t; i++){
            n = sc.nextInt();
            l = sc.nextInt();
            r = sc.nextInt();
            if (n % r == 0){
                System.out.println("Yes");
                continue;
            }
            else{
                int x = n / r;
                if (x == 0){
                    if (l<= n && n <= r){
                        System.out.println("Yes");
                        continue;
                    }
                    else{
                        System.out.println("No");
                        continue;
                    }
                }
                int d = n % r;
                if (d >= l){
                    System.out.println("Yes");
                    continue;
                }
                else{
                    int m = (l - d) / x + ((l - d) % x == 0 ? 0 : 1);
                    if (r - m >= l){
                        System.out.println("Yes");
                    }
                    else{
                        System.out.println("No");
                    }
                }
            }
        }
    }
}
