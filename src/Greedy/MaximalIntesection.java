package Greedy;

import java.util.*;

public class MaximalIntesection {
    public static class Interval implements Comparable<Interval>{
        public int l, r;
        public Interval(int l, int r){
            this.r = r;
            this.l = l;
        }

        @Override
        public int compareTo(Interval I) {
            if (I.l < this.l){
                return 1;
            }
            else if (I.l > this.l){
                return -1;
            }
            else{
                if (I.r > this.r){
                    return -1;
                }
                else if (I.r < this.r){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, l, r, first_smallest, second_smallest, d = 0;
        Interval[] intervals = new Interval[n];
        for (i = 0; i < n; i++){
            l = sc.nextInt();
            r = sc.nextInt();
            intervals[i] = new Interval(l, r);
        }
        Arrays.sort(intervals);
        first_smallest = intervals[0].r;
        second_smallest = intervals[n - 1].r;

        for (i = 1; i < n - 1; i++){
            if (first_smallest >= intervals[i].r){
                second_smallest = first_smallest;
                first_smallest = intervals[i].r;
            }
            else if (second_smallest > intervals[i].r){
                second_smallest = intervals[i].r;
            }
        }
        if (second_smallest != Integer.MAX_VALUE){
            d = Math.max(d, second_smallest - intervals[n - 1].l);
        }
        else{
            d = intervals[n - 1].r - intervals[n - 1].l;
        }
        d = Math.max(d, first_smallest - intervals[n - 2].l);
        System.out.println(d);
    }
}
