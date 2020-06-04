import java.io.*;
import java.util.*;

public class TaskA {
    static private double PI = Math.PI;
    public static void main(String[] args) {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
        int t = sc.nextInt();
        int n;
        for (int i = 0; i < t; i++){
            n = sc.nextInt();
            System.out.println(solve(n));
        }
    }

    private static double solve(int n) {
        double num = Math.cos(PI / (4 * n));
        double det = Math.sin(PI / (2 * n));
        return num / det;
    }
}
