package Dynamic_Programming;

public class MaximumOfThreeSubArray {
    public static void main(String[] args) {
        int[] nums = {7,13,20,19,19,2,10,1,1,19};
        int k = 3;
        int[] r = maxSumOfThreeSubarrays(nums, k);
        for (int i = 0; i < 3; i++){
            System.out.print(r[i] + " ");
        }
    }
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        int l = nums.length;
        int r = 0;
        int max = -1;

        int k_sub[] = new int[l];
        int left[] = new int[l];
        int right[] = new int[l];
        for (int i = 0; i < k; i++){
            r += nums[i];
        }
        k_sub[0] = r;
        left[0] = 0;
        right[l - 1] = l - 1;

        for (int i = 1; i <= l - k; i++){
            k_sub[i] = k_sub[i - 1] + nums[i + k - 1] - nums[i - 1];
            left[i] = (k_sub[left[i - 1]] < k_sub[i]) ? i : left[i - 1];
        }
        for (int i = l - 2; i >= 0; i--){
            right[i] = (k_sub[right[i + 1]] <= k_sub[i])? i : right[i + 1];
        }

        for (int _center = k; _center < l - k; _center++){
            int _left = left[_center - k];
            int _right = right[_center + k];
            int sum = k_sub[_left] + k_sub[_center] + k_sub[_right];
            if (sum > max){
                res[0] = _left;
                res[1] = _center;
                res[2] = _right;
                max = sum;
            }
        }
        return res;
    }
}
