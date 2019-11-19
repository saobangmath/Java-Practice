package Interview;

import java.util.ArrayList;
import java.util.TreeSet;

public class ArrayIntersection {
    public static  int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> t1 = new TreeSet<>();
        TreeSet<Integer> t2 = new TreeSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums1){
            t1.add(num);
        }
        for (int num : nums2){
            t2.add(num);
        }
        for (int num : t1){
            if (t2.contains(num)){
                res.add(num);
            }
        }
        int s = res.size();
        int[] r = new int[s];
        for (int i = 0; i < s; i++){
            r[i] = res.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,2,1,3};
        int[] b = {2,3,1,3,6,1};
        System.out.println(intersection(a, b));
    }
}
