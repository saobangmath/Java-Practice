package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumHiringCost {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int K = 2;
        assert (new MinimumHiringCost().mincostToHireWorkers(quality, wage, K) == 105);
    }
    public static class Worker implements Comparable<Worker>{
        public int q;
        public double unit;
        public Worker(int q, double unit){
            this.q = q;
            this.unit = unit / q;
        }
        public int compareTo(Worker p){
            if (this.unit > p.unit){
                return 1;
            }
            else if(this.unit < p.unit){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
    static class CustomSort implements Comparator<Worker> {

        @Override
        public int compare(Worker o1, Worker o2) {
            if (o1.q > o2.q){
                return -1;
            }
            else if (o1.q < o2.q){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<Worker> pq = new PriorityQueue<Worker>(new CustomSort());
        int n = quality.length;
        Worker[] workers = new Worker[n];
        int i;
        double total = 0.0;
        double result = Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        for (i = 0; i < n; i++){
            workers[i] = new Worker(quality[i], (double)wage[i]);
            min = Math.min(min, wage[i]);
        }
        if (K == 1){
            return min;
        }
        Arrays.sort(workers);
        for (i = 0; i < K; i++){
            total += workers[i].q;
            pq.offer(workers[i]);
        }

        result = total * workers[K - 1].unit;

        while (i < n){
            Worker target = workers[i];
            Worker top = pq.peek();
            double units = total + (target.q - top.q);
            if (target.q <= top.q){
                pq.poll();
                pq.offer(target);
                total = units;
            }
            result = Math.min(result, units * target.unit);
            i++;
        }
        return result;
    }
}
