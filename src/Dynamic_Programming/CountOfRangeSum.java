package Dynamic_Programming;
import java.util.Scanner;

public class CountOfRangeSum {
    static int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        int count = 0;
        long prefix[] = new long[len + 1];
        for (int i = 1; i <= len; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
            System.out.println(prefix[i]);
        }
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len + 1; j++){
                long d = prefix[j] - prefix[i];
                if (d >= lower && d <= upper) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(countRangeSum(arr, lower, upper));
    }
}
