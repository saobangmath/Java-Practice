public class TaskA {
    public static void main(String[] args) {
       int n = 6;
       int[] arr = {2, 4, 5, 1, 3};
       assert(MissingNumber(arr) == 6);
    }
    public static int MissingNumber(int[] arr){
        int result = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++){
            result = result ^ ((i + 1) ^ arr[i]);
        }
        result = result ^ (l + 1);
        return result;
    }
}
