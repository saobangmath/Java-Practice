package Greedy;

import java.util.Scanner;

public class LargestArea {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0 ; i < n; ++i){
            height[i] = sc.nextInt();
        }
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int max = 0;
        // 2 pointer approach O(n)
        int beg = 0;
        int end = height.length - 1;
        while (beg < end){
            int r = (end - beg);
            if (height[beg] > height[end]){
                r = r * height[end];
                --end;
            }
            else{
                r = r * height[beg];
                ++beg;
            }
            max = (max >  r) ? max : r;
        }
        return max;
    }
}
