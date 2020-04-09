package Codeforce.div2;

import java.util.HashMap;
import java.util.Scanner;

public class Uniqueness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int i, start, end, beg;
        for (i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        int result = -1;
        for (start = 0; start < n; start++){
            if (freq.getOrDefault(a[start], 0) != 0){
                result = n - start;
                break;
            }
            else{
                freq.put(a[start], 1);
            }
        }
        if (start == n){
            System.out.println(0);
            return;
        }
        for (end = n - 1; end > start; end--){
            if (freq.getOrDefault(a[end], 0) != 0){
                result = end - start + 1;
                break;
            }
            else{
                freq.put(a[end], 1);
            }
        }

        for (beg = start - 1; beg >= 0; beg--){
            int au = freq.get(a[beg]);
            freq.put(a[beg], au - 1);
            while (freq.getOrDefault(a[end], 0) == 0){
                freq.put(a[end], 1);
                end--;
            }
            if (end - beg + 1 < result){
                result = end - beg + 1;
            }
        }
        System.out.println(result);
    }
}
