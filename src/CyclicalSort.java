import java.util.Scanner;

public class CyclicalSort {
    public double Minimum(double ar[], int beg,int end){
        int mid = (beg + end) / 2;
        if (mid == beg){
            return Math.min(ar[beg],ar[end]);
        }
        else if (ar[mid] <= ar[end]){
            return Minimum(ar,beg,mid);
        }

        else{
            return Minimum(ar,mid,end);
        }
    }
    public static void main(ReverseString[] args) {
        Scanner sc = new Scanner(System.in);
        CyclicalSort cyclicalSort = new CyclicalSort();
        int n = sc.nextInt();
        double[] ar = new double[n];
        for (int i = 0; i < n; i++){
            ar[i] = sc.nextDouble();
        }
        System.out.println(cyclicalSort.Minimum(ar,0,n-1));
    }
}
