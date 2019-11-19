package HashMap;

import java.util.Scanner;
import java.util.TreeMap;

public class FindSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int Sum = sc.nextInt();
        System.out.println("No sub arr of arr with sum == " + Sum + " is: " + findSubArraySum(arr, n, Sum));
    }

    private static int findSubArraySum(int[] arr, int n, int Sum) {
        TreeMap<Integer, Integer> prevSum = new TreeMap();
        int r = 0;
        int l =  arr.length;
        int cur_sum = 0;
        for (int i = 0; i < l; i++){
            cur_sum += arr[i];
            int old_value = 0;
            if (cur_sum == Sum) { // found a subarray with sum == Sum
                r += 1;
            }
            if (prevSum.containsKey(cur_sum - Sum)) {
                r += prevSum.get(cur_sum - Sum);
            }
            try{
                old_value = prevSum.get(cur_sum);
            }
            catch(Exception e){

            }
            finally {
                prevSum.put(cur_sum, old_value + 1);
            }
        }
        return r;
    }

}
