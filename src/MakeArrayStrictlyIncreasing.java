import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeArrayStrictlyIncreasing {
    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < arr2.length; i++){
            if (i + 1 < arr2.length && arr2[i] == arr2[i+1]){
                continue;
            }
            list.add(arr2[i]);
        }
        int[] newarr2 = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            newarr2[i] = list.get(i);
        }
        arr2 = newarr2; // sorted arr2 and eliminate all duplicated value
        // generate new arr1
        int[] new_arr1 = new int[n + 2];
        for (int i = 0; i < n; i++){
            new_arr1[i + 1] = arr1[i];
        }
        new_arr1[n + 1] = Integer.MAX_VALUE;
        new_arr1[0] = Integer.MIN_VALUE;
        arr1 = new_arr1;

        int[] dp = new int[n + 2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 2; i++){
            for (int j = 0; j < i;j++){
                if (arr1[j] < arr1[i] && dp[j] != Integer.MAX_VALUE){
                    int change = check(arr1, arr2, j, i);
                    if (change >= 0){
                        dp[i] = Math.min(dp[i], dp[j] + change);
                    }
                }
            }
        }
        return dp[n+1] == Integer.MAX_VALUE ? -1 : dp[n+1];
    }

    private static int check(int[] arr1, int[] arr2, int start, int end) {
        if (start + 1 == end){
            return 0;
        }
        else{
            int min = arr1[start];
            int max = arr1[end];
            int idx = Arrays.binarySearch(arr1, min);
            idx = (idx < 0)? -idx - 1 : idx + 1;
            int MaxCount = end - start - 1;
            int endi = idx + MaxCount - 1;
            if (endi < arr2.length && arr2[endi] < max){
                return MaxCount;
            }
            else{
                return -1;
            }
        }
    }

    public static void main(ReverseString[] args) {
       int[] arr1 =  {1,5,3,6,7};
       int[] arr2 =  {1,3,2,4};
       System.out.println(makeArrayIncreasing(arr1, arr2));
    }
}
