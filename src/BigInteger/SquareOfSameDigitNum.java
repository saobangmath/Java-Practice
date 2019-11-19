package BigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class SquareOfSameDigitNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int N = sc.nextInt();
        String s = "";
        for (int i = 0; i < N; i++){
            s = s + d;
        }
        BigInteger res = new BigInteger(s);
        System.out.println(res.multiply(res));
    }
}
