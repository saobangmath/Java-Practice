import java.util.Scanner;

public class Sorting_Algorithm {
    int[]arr;
    public Sorting_Algorithm(int n){
        this.arr = new int[n];
    }
    public static void Mergesort(int[]arr,int beg,int end){
        if (beg >= end) {
            return;
        }
        else{
            int mid = (beg + end) / 2;
            Mergesort(arr,beg,mid);
            Mergesort(arr,mid+1,end);
            Merge(arr,mid,beg,end);
        }
    }

    private static void Merge(int[]arr, int mid,int beg,int end) {
        int[] b = new int[end - beg + 1];
        int i1 = beg;
        int i2 = mid+1;
        int i = 0;
        while (i1 <= mid && i2 <= end){
            int num = arr[i1];
            if (arr[i1] > arr[i2]){
                num = arr[i2];
                i2++;
            }
            else{
                i1++;
            }
            b[i] = num;
            i++;
        }
        if (i1 <= mid){ // the first half array still has numbers left
            for (int x = i1; x <= mid; x++){
                b[i] = arr[x];
                i++;
            }
        }
        else{ //  the second half array has numbers left
            for (int y = i2; y <= end; y++){
                b[i] = arr[y];
                i++;
            }
        }
        for (i = beg ; i <= end; i++){
            arr[i] = b[i - beg];
        }
    }

    public static void HeapSort(int[] arr) {
        int n = arr.length;
        // Build the max heap
        // idea: to build the 2 subtree of the Heap to be MaxHeap first, then Merge tgt by running Heapify func
        for (int i = n / 2 - 1; i >= 0; i--){
            Heapify(arr,n,i);
        }
        for (int i = n-1; i >= 0; i--){
            swap(arr,0, i);
            Heapify(arr,i,0);
        }
    }
    // heapify a subtree rooted with node i
    public static void Heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // left
        int r = 2 * i + 2; // right
        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if (largest != i){
            swap(arr, largest, i);
            Heapify(arr,n,largest);
        }
    }
    public static void RadixSort(int[] arr) {

    }

    public static void QuickSort(int[] arr, int beg, int end){
        if (beg < end){
            int pos = partition(arr, beg, end);
            QuickSort(arr,beg,pos-1);
            QuickSort(arr,pos+1,end);
        }
    }
    public static int partition(int[] arr, int beg, int end){
        int mid = (beg + end) / 2;
        swap(arr,beg,mid);
        int pivot = arr[beg];
        int last_small = beg;
        for (int i = beg + 1; i <= end; i++){
            if (arr[i] <= pivot){
                swap(arr,++last_small, i);
            }
        }
        swap(arr,last_small,beg);
        return last_small;
    }

    public static void main(ReverseString[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sorting_Algorithm sorting_algorithm = new Sorting_Algorithm(n);
        for (int i = 0; i < n; i++){
            sorting_algorithm.arr[i] = sc.nextInt();
        }
        HeapSort(sorting_algorithm.arr);
        Display(sorting_algorithm.arr);
        sc.close();
    }
    public static void swap(int[]arr,int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }
    public static void Display(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
