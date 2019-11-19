package Dynamic_Programming;

import java.util.HashMap;
import java.util.Scanner;

public class MaximumEqualFrequency {
    public static  int maxEqualFreq(int[] nums) {
        int max = 1;
        int max_occ = 0;
        int min_occ = 0;
        HashMap<Integer, Integer> hm =  new HashMap<>();
        for (int i = 0; i < nums.length; i++){

        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println(maxEqualFreq(a));
    }
}
