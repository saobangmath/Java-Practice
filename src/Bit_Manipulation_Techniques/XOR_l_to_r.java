package Bit_Manipulation_Techniques;

public class XOR_l_to_r {
    public static long XOR_l_to_r(long l, long r){
        XOR_1_to_N object = new XOR_1_to_N();
        long a = object.XOR_1_to_N(r);
        long b = object.XOR_1_to_N(l - 1);
        return a ^ b;
    }
    public static void main(String[] args) {
        long l = 4, r = 8;
        System.out.println(XOR_l_to_r(l, r));
    }
}
