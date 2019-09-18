import java.util.Scanner;

public class ReverseString {

    private static String ReverseString(String s) {
        int count = 0;
        String res = "";
        int j = -1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch != '(' && ch !=')'){
                res += ch;
            }
            else{
                j = i;
                break;
            }
        }
        if (j != -1) {
            for (int i = j; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch == '('){
                    count++;
                }
                else if (ch == ')'){
                    count--;
                }
                if (count == 0){
                    return res + ReverseString(Reverse(s.substring(j,i+1))) + ReverseString(s.substring(i + 1, s.length()));
                }
            }
        }
        return res;
    }

    private static String Reverse(String s) {
        String res = "";
        for (int x = s.length() - 2; x >= 1; x --){
            char ch = s.charAt(x);
            if (ch == ')'){
                res += '(';
            }
            else if (ch == '('){
                res += ')';
            }
            else{
                res += ch;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(ReverseString(s));
        sc.close();
    }
}
