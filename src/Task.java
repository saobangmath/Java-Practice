import java.util.*;
/// need to clean too much codes

public class Task {
    static int[] a = new int[100000];
    //static int[] result = new int[100000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            for (int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            System.out.println(solve(a, n));
        }
    }

    private static int solve(int[] a, int n) {
        int result = 0, d;
        for (int i = 1; i < n; i++){
            if (a[i] < a[i - 1]) {
                d = (int)Math.ceil(Math.log10(a[i - 1] - a[i] + 1) / Math.log10(2));
                a[i] = a[i  - 1];
                result = Math.max(result, d);
            }
        }
        return result;
    }
}
