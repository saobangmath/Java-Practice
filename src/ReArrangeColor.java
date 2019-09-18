import java.util.Scanner;

public class ReArrangeColor {
    public static void main(ReverseString[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first_not_neg = 0;
        int last_not_pos = n - 1;
        int[]arr = new int[n]; // this  array merely has -1,0 or 1;
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // set up the first pos of not -1;
        while (first_not_neg < n && arr[first_not_neg] == -1){
            first_not_neg ++;
        }
        // set up the last pos of not 1;
        while (last_not_pos >= 0 && arr[last_not_pos] == 1){
            last_not_pos --;
        }
        int i = first_not_neg;
        while (last_not_pos > first_not_neg ){
            while (i <= last_not_pos){
                if (arr[i] == 1){
                    swap(arr,i,last_not_pos--);
                }
                else {
                    if (arr[i] == -1) {
                        swap(arr, i, first_not_neg++);
                    }
                    i++;
                }
            }
        }
        DisPlay(arr);
        sc.close();
    }
    static void swap(int[]arr,int a,int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }
    static void DisPlay(int[] arr){
        for (int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
