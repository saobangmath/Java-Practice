package Greedy;

import java.io.*;
import java.util.*;

public class Equalization {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        int max = 0, target = -1, in = -1;
        int i;
        Map<Integer, Integer> hm = new HashMap<>();
        String[] s = bf.readLine().split(" ");
        for (i = 0; i < n; i++){
            a[i] = Integer.parseInt(s[i]);
            int au = hm.getOrDefault(a[i], 0) + 1;
            hm.put(a[i], au);
            if (au > max){
                max = au;
                target = a[i];
                in = i;
            }

        }
        System.out.println(n - max);
        for (i = in - 1; i >= 0; i--){
            if (a[i] > target){
                System.out.println("2 " + (i + 1) + " " + (i + 2));
            }
            else if (a[i] < target){
                System.out.println("1 " + (i + 1) + " " + (i + 2));
            }
        }
        for (i = in + 1; i < n; i++){
            if (a[i] > target){
                System.out.println("2 " + (i + 1) + " " + i);
            }
            else if (a[i] < target){
                System.out.println("1 " + (i + 1)  + " " + i);
            }
        }
    }
}
