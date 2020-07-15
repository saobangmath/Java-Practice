package Codeforce.div2;

import java.util.HashMap;
import java.util.Scanner;

public class MagicStone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i, au, t;
        for (i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for (i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        if (a[0] != b[0] || a[n - 1] != b[n - 1]){
            System.out.println("No");
            return;
        }
        for (i = 1; i < n; i++){
            au = a[i] - a[i - 1];
            t = hm.getOrDefault(au, 0);
            hm.put(au, t + 1);
        }
        for (i = 1; i < n; i++){
            au = b[i] - b[i - 1];
            t = hm.getOrDefault(au, 0);
            if (t == 0){
                System.out.println("No");
                return;
            }
            else{
                hm.put(au, t - 1);
            }
        }
        System.out.println("Yes");
    }
}
