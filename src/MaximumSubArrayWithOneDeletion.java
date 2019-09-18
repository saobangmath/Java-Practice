public class MaximumSubArrayWithOneDeletion {
    public static int maximumSum(int[] arr) {
        int len = arr.length;
        int[] f = new int[len]; // store res when delete exactly 1
        int[] g = new int[len]; // store res when nothing deleted
        int max = arr[len - 1];
        g[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0;i--) {
            f[i] = Math.max(f[i + 1] + arr[i], g[i + 1]);
            g[i] = Math.max(arr[i], g[i + 1] + arr[i]);
            max = Math.max(Math.max(f[i], g[i]), max);
        }
        return max;
    }
    public static void main(ReverseString[] args) {
        int[] arr = {1, -2, -2, 3};
        System.out.println(maximumSum(arr));
    }
}
