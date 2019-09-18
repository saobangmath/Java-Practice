import java.util.Arrays;
import java.util.Scanner;

public class NStack {
    public static void main(ReverseString[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]stack = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++){
            stack[i] = sc.nextInt();
        }

        Arrays.sort(stack);
        int t = stack[n-1];
        int count = 1;
        for (int i = n-2; i >= 0; i--){
            if (stack[i] != t){
                t = stack[i];
                res += count;
            }
            count++;
        }
        System.out.println(res);
    }
}
