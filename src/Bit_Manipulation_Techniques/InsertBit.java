package Bit_Manipulation_Techniques;
import java.io.*;
public class InsertBit{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.println(insertBits(n, a, b, k));
    }
    static int insertBits(int n, int a, int b, int k) {
        return (int)(n - find(n, a, b) + find(k, 0, b - a) * (int)Math.pow(2, a));
    }
    static long find(int n, int a, int b){
        long x = (long)Math.pow(2, a);
        long y = (long)Math.pow(2, b - a + 1);
        return x *((n / x) % y);
    }
}
