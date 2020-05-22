import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.StringBuffer;
public class ProbA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            if (n % 2 == 1){
                n-=3;
                System.out.print(7);
            }
            while (n > 0){
                System.out.print("1");
                n -= 2;
            }
            System.out.println();
        }
    }
}
