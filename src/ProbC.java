import java.util.Scanner;

public class ProbC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long arr[] = new long[N];
        long total = 0;
        for (int i = 0 ; i < N; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        int X = sc.nextInt();
        if (N == 0){
            System.out.println(0);
        }
        else if (X + 1 >= 0){
            System.out.println(maxSub(arr) * (X + 1) - total);
        }
        else{
            System.out.println(minSub(arr) * (X + 1) - total);
        }
    }
    static long maxSub(long[] arr){
        long cur = 0;
        long max = arr[0];
        for (int i = 0; i < arr.length; i++){
            cur += arr[i];
            max = (cur > max) ? cur : max;
            cur = (cur <= 0)? 0 : cur;
        }
        return max;
    }
    static long minSub(long[] arr){
        long cur = 0;
        long min = arr[0];
        for (int i = 0; i < arr.length; i++){
            cur += arr[i];
            min = (cur < min) ? cur : min;
            cur = (cur >= 0)? 0 : cur;
        }
        return min;
    }
}

