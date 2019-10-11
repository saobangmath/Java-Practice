package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Triple implements Runnable{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long r = sc.nextLong();
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            long a  = sc.nextLong();
            arr.add(a);
        }
        System.out.println(res(arr, r));
    }

    private static long res(List<Long> arr, long r) {
        HashMap<Long, Long> pairs = new HashMap(); // Map to store the pair (i, j) : (j > i && a[j] = a[i] * r)
        HashMap<Long, Long> count = new HashMap(); // Map to store the number of a[i] from 0 to i that is equal to a[i]
        long res = 0;
        for (int i = 0 ; i < arr.size(); ++i){
            long t = arr.get(i);
            UpdateCount(count, t);
            if (t % r == 0){
                try{
                    res += pairs.get(t / r);
                    long update = count.get(t / r) + pairs.get(t);
                    pairs.put(t, update);
                }
                catch (Exception e){
                    pairs.put(t, count.get(t / r));
                }
            }
            else{
                pairs.put(t, (long)0);
            }

        }
        return res;
    }

    private static void UpdateCount(HashMap<Long, Long> count, long t) {
        try{
            long num = count.get(t);
            count.put(t, num + 1);
        }
        catch(Exception e){
            count.put(t, (long)0 + 1);
        }
    }

    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
