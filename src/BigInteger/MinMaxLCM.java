package BigInteger;

import java.util.*;

public class MinMaxLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        int sqrt = (int)Math.sqrt(X);
        long cur = 1;
        long temp = X;
        HashMap<Long, Integer> count = new HashMap<>();
        List<Long> primes = new ArrayList<>();
        for (long d = 2; d <= sqrt; d++){
            int c = 0;
            while (temp % d == 0){
                temp = temp / d;
                c++;
            }
            if (c != 0){
                primes.add(d);
                count.put(d, c);
            }
            if (X == 1){
                break;
            }
        }
        if (X != 1){
            count.put(X, 1);
        }
        long max = (solve(X, count, primes, cur, 0));
        System.out.println(X / max + " " + max);
    }

    private static long solve(long X, HashMap<Long, Integer> count, List<Long> primes, long cur, int i) {
        int l = primes.size();
        if (i == l){
            return Math.max(cur, X / cur);
        }
        else{
            long result = Long.MAX_VALUE;
            for (int j = i; j < l; j++){
                long au = cur * (long)Math.pow(primes.get(j), count.get(primes.get(j)));
                result = Math.min(result, solve(X, count, primes, au, j + 1));
            }
            return result;
        }
    }
}
