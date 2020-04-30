package Number_Theory;

import java.math.BigInteger;
import java.util.*;

public class ConcanatedMultiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> hm = new HashMap<>();
        int i;
        long result = 0;
        for (i = 0; i < n; i++){
            a[i] = sc.nextInt();
            int d = hm.getOrDefault(a[i] % k, 0) + 1;
            hm.put(a[i] % k, d);
        }
        for (i = 0; i < n; i++){
            int remain = (k - (a[i] % k)) % k;
            int t = (int)(func(a[i]) % k);
            int g = gcd(t, k);
            if (t == 0){
                if (remain % k == 0){
                    result += n - 1;
                }
            }
            else if (remain % g == 0){
                int au = k / g;
                int u = t / g;
                int v = remain / g;
                int modinverse = Integer.parseInt(new BigInteger(u + "").modInverse(new BigInteger(au + "")).toString());
                int mod = (int)(((long)(v) * modinverse) % au);
                while (mod < k){
                    result += hm.getOrDefault(mod, 0);
                    if (mod == a[i] % k){
                        result--;
                    }
                    mod += au;
                }
            }
        }
        System.out.println(result);
    }
    static private long func(int n){
        long c = 1;
        while (n > 0){
            c = c * 10;
            n = n / 10;
        }
        return c;
    }
    static private int gcd(int a, int b){
        if (a == 0){
            return b;
        }
        else{
            if (a <= b){
                return gcd(b % a, a);
            }
            else{
                return gcd(b, a);
            }
        }
    }
}
