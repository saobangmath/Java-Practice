package Dynamic_Programming;

import java.util.Scanner;

public class MaximumSubArrayProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(MaximumSubArrayProd(nums));
    }

    private static int MaximumSubArrayProd(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];
        int min[] = new int[n];
        max[0] = min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == 0){
                max[i] = min[i] = 0;
            }
            else if (nums[i] > 0){
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            }
            else{
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
