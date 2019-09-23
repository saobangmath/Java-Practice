package Greedy;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++){
            ar[i] = sc.nextInt();
        }
        System.out.println(minimumSwap(ar));
        sc.close();
    }

    private static int minimumSwap(int[] ar) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < ar.length; i++){
            hm.put(ar[i], i);
        }
        for (int i = 1; i <= ar.length; i++){
            int cur_pos = hm.get(i);
            if (cur_pos != i - 1){
                hm.put(hm.get(i - 1),cur_pos);
                ++count;
            }
        }
        return count;
    }
}
