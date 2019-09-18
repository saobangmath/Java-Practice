package Bit_Manipulation_Techniques;

public class XOR_1_to_N {
    public static long XOR_1_to_N(long N){
        long mod = (N % 4);
        long res;
        if (mod == 0){
            res = N;
        }
        else if (mod == 1){
            res = 1;
        }
        else if (mod == 2){
            res = N + 1;
        }
        else{
            res = 0;
        }
        return res;
    }
    public static void main(String[] args) {
        long n = 6;
        System.out.println(XOR_1_to_N(n));
    }
}
