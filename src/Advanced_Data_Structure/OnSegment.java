package Advanced_Data_Structure;

import java.util.Scanner;

public class OnSegment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        boolean[] mark = new boolean[101];
        int i, x, count = 0;
        for (i = 0; i < n; i++){
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }
        for (i = 1; i < n; i++){
            for ( x = l[i]; x < r[i]; x++){
                mark[x] = true;
            }
        }
        for (x = l[0]; x < r[0]; x++){
            if (!mark[x]){
                count++;
            }
        }
        System.out.println(count);
    }
}
