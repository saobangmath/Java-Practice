package Number_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultiColorMakers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");

        long a = Long.parseLong(ab[0]);
        long b = Long.parseLong(ab[1]);
        long result = 0;

        int a_nearest, b_nearest;
        // vector set up
        Vector<Integer> a_div = allDiv(a);
        Vector<Integer> b_div = allDiv(b);
        Vector<Integer> ab_div = allDiv(a + b);

        int l_a = a_div.size();
        int l_b = b_div.size();
        int l_ab = ab_div.size();

        for (int i = l_ab - 1; i >=0; i--){
            a_nearest = binarySearch(a_div, ab_div.get(i), 0, l_a - 1);
            b_nearest = binarySearch(b_div, ab_div.get(i), 0, l_b- 1);
            // a as an inner rect
            if (a / a_nearest <= (a + b) / ab_div.get(i)){
                result = (ab_div.get(i) + (a + b) / ab_div.get(i)) * 2;
            }
            // b as an inner rect
            if (result == 0 && b / b_nearest <= (a + b) / ab_div.get(i) ){
                result = (ab_div.get(i) + (a + b) / ab_div.get(i)) * 2;
            }
            if (result != 0){
                System.out.println(result);
                return;
            }
        }
    }

    private static int binarySearch(Vector<Integer> arr, Integer target, int beg, int end) {
        if (beg > end){
            return -1;
        }
        if (beg == end){
            return (arr.get(beg) <= target)? arr.get(beg) : -1;
        }
        else if (beg + 1 == end){
            if (arr.get(end) <= target){
                return arr.get(end);
            }
            else{
                return arr.get(beg);
            }
        }
        else{
            int mid = (beg + end) / 2;
            if (arr.get(mid) == target){
                return target;
            }
            else if (arr.get(mid) < target){
                return binarySearch(arr, target, mid, end);
            }
            else{
                return binarySearch(arr, target, beg, mid - 1);
            }
        }
    }

    public static Vector<Integer> allDiv(long n){
        Vector<Integer> all = new Vector<>();
        for (long i = 1; i * i <= n; i++){
            if (n % i == 0){
                all.add((int)i);
            }
        }
        return all;
    }
}
