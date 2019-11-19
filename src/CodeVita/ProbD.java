package CodeVita;

import java.util.HashMap;
import java.util.Scanner;

public class ProbD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }
        int queries = sc.nextInt();
        for (int q = 1; q <= queries; q++){
            int L1 = sc.nextInt();
            int H1 = sc.nextInt();
            int L2 = sc.nextInt();
            int H2 = sc.nextInt();
            int count = 0;
            HashMap<Integer, Boolean> hm = new HashMap<>();
            HashMap<Integer, Boolean> res = new HashMap<>();
            for (int i = L1 - 1; i <  H1; i++){
                hm.put(a[i], true);
            }
            for (int i = L2 - 1; i < H2; i++){
                hm.put(b[i], true);
            }
            for (int i = 0; i < L1 - 1; i++){
                try {
                    boolean t = (hm.get(a[i]));
                }
                catch (Exception e){
                    hm.put(a[i], true);
                    count++;
                }
            }
            for (int i = H1; i < n; i++){
                try {
                    boolean t = (hm.get(a[i]));
                }
                catch (Exception e){
                    hm.put(a[i], true);
                    count++;
                }
            }
            for (int i = 0; i < L2 - 1; i++){
                try {
                    boolean t = (hm.get(b[i]));
                }
                catch (Exception e){
                    hm.put(b[i], true);
                    count++;
                }
            }
            for (int i = H2;i < n; i++){
                try {
                    boolean t = (hm.get(b[i]));
                }
                catch (Exception e){
                    hm.put(b[i], true);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
