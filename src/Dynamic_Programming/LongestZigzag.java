package Dynamic_Programming;

public class LongestZigzag {
    static int zigzagSequenceLength(int[] a)
    {
        int l = a.length;
        int inc[] = new int[l];
        int dec[] = new int[l];
        dec[l - 1] = inc[l - 1] = 1;
        int r = 1;
        for (int i = l - 2; i >= 0; i--){
            dec[i] = inc[i] = 1;
            for (int j = i + 1; j < l; j++){
                if (a[i] > a[j]){
                    dec[i] = Math.max(dec[i], 1 + inc[j]);
                }
                else if (a[i] < a[j]){
                    inc[i] = Math.max(inc[i], 1 + dec[j]);
                }
            }
            int t =  Math.max(dec[i], inc[i]);
            r = (r > t)? r : t;
            System.out.println(r);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
        System.out.println(zigzagSequenceLength(arr));
    }
}
