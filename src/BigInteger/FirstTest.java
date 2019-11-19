package BigInteger;

import java.math.BigInteger;

public class FirstTest {
    public static void main(String[] args) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= 10000;i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);
    }
}
