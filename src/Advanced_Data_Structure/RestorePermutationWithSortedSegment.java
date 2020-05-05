package Advanced_Data_Structure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RestorePermutationWithSortedSegment {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter pw = new PrintWriter(out);
        int t = Integer.parseInt(br.readLine());
        int[] a = new int[201];
        // priority queue for storing
        PriorityQueue<PriorityQueue<Integer>> pq;
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int j;
            // create a priority queue to store the list of another priority queue under custom comparator;
            pq = new PriorityQueue<>(new CustomComparator());
            // the main solver
            for (j = 2; j <= n; j++){
                String[] seg = br.readLine().split(" ");
                int l = Integer.parseInt(seg[0]);
                int x, num;
                // read the input into the priority queue;
                PriorityQueue<Integer> au = new PriorityQueue<>();
                for (x = 1; x <= l; x++){
                    num = Integer.parseInt(seg[x]);
                    au.offer(num);
                }
                pq.offer(au);
            }
            // the important is when choosing first and second element, the other next element is uniquely identify
            // as at any position from 3 onward, while our segments continue to eliminate the filled element
            // there always exist exactly 1 elements with exactly 1 element left.
            int first = 1;
            for (first = 1; first <= n; first++){
                int remain_one = 0;
                for (PriorityQueue<Integer> au : pq){
                    if (au.size() == 2 && au.contains(first)){
                        remain_one++;
                    }
                }
                if (remain_one == 1){
                    // now we are choosing the right first beginning elements;
                    int cnt = n;
                    int nxt = first;

                    while (cnt > 0){
                        a[n - cnt] = nxt;
                        pw.print( a[n - cnt] + " ");
                        for (PriorityQueue<Integer> au : pq){
                            if (au.contains(nxt)){
                                au.remove(nxt);
                            }
                        }
                        try{
                            nxt = (pq.poll()).poll();
                        }
                        catch (Exception e){

                        }
                        cnt--;
                    }
                    pw.println();
                }
            }
        }
        pw.close();
    }

    // custom comparator
    static class CustomComparator implements Comparator<PriorityQueue<Integer>>{

        @Override
        public int compare(PriorityQueue<Integer> o1, PriorityQueue<Integer> o2) {
            if (o1.size() > o2.size()){
                return 1;
            }
            else if (o1.size() < o2.size()){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}
