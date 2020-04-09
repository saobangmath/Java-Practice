package BigInteger;
import java.util.Scanner;

public class Nineteen {
    //nineteen
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = 0,i = 0, e = 0, t = 0;
        int l = s.length();
        for(int ii = 0; ii < l ;ii++){
            char ch = s.charAt(ii);
            if (ch == 'n'){
                n++;
            } else if (ch == 'i') {
                i++;
            }
            else if (ch == 't'){
                t++;
            }
            else if (ch == 'e'){
                e++;
            }
        }
        n = (n - 1) / 2; e = e / 3;
        System.out.println(Math.min(Math.min(n, e), Math.min(t, i)));
    }
}
