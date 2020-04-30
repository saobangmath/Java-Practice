import java.io.*;
import java.util.*;

//
//public class Solution {
//    static int[] a = new int[200000];
//    static int[] cnt = new int[400001];
//    static int[] pref = new int[400001];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++){
//            String[] nk = br.readLine().split(" ");
//            String[] in = br.readLine().split(" ");
//            int n = Integer.parseInt(nk[0]);
//            int k = Integer.parseInt(nk[1]);
//            for (int j = 0; j < n; j+=1){
//                a[j] = Integer.parseInt(in[j]);
//            }
//            solve(n, k);
//        }
//    }
//    private static void solve(int n, int k) {
//        int i, l, r, target, au, min = n;
//        for (i = 2; i <= 2 * k; i++){
//            cnt[i] = 0;
//            pref[i] = 0;
//        }
//        for (i = 0; i < n / 2; i++){
//            cnt[a[i] + a[n - 1 - i]]++;
//            l = Math.min(a[i], a[n - 1 - i]) + 1;
//            r = Math.max(a[i], a[n - 1 - i]) + k + 1;
//            pref[l]++;
//            if (r <= 400000){
//                pref[r]--;
//            }
//        }
//        int prefsum = 0;
//        for (target = 2; target <= 2 * k; target++){
//            prefsum += pref[target];
//            au =   n - cnt[target] - prefsum;
//            min = Math.min(min, au);
//        }
//        System.out.println(min);
//    }
//}
//
//
//
//
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minStringCoeff' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER p
     */

    public static int minStringCoeff(String s, int p) {
        // Write your code here
        int ls = s.length();
        int i, c, t, x;
        List<Integer> clusters = new ArrayList<>();
        i = 1; c = 1; x = 1;
        t = s.charAt(0) - '0';
        while (i < ls){
            int d = s.charAt(i++) - '0';
            if (d == t){
                c++;
            }
            else{
                t = d;
                clusters.add(c);
                c = 1;
                x++;
            }
        }
        clusters.add(c);
        if (x <= 2){
            return 0;
        }
        return solve(clusters, ls - clusters.get(0) - clusters.get(x - 1), p, 1, x - 2);
    }
    static int solve(List<Integer> clusters, int n, int p, int beg, int end){
        if (p == 0){
            return n;
        }
        else if (end <= beg || (end - beg + 1) / 2 <= p){
            return 0;
        }
        else{
            while (beg <= end - 2 && p > 0) {
                int l = clusters.get(beg) + clusters.get(beg + 1);
                int r = clusters.get(end - 1) + clusters.get(end);
                if (l > r){
                    beg += 2;
                    n -= l;
                }
                else{
                    end -= 2;
                    n -= r;
                }
            }
            if (beg <= end - 2){
                return 0;
            }
            else{
                return n;
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = "";
        for (int i = 0; i < 1000000; i++){
            s = s + (i % 2);
        }
        int p = 499998;
        int res = Result.minStringCoeff(s, p);
        System.out.println(res);
    }
}

