import java.util.Scanner;

public class ProbF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int ls = S.length();
        int lt = T.length();
        int s = 0,  t = 0;
        int open = 0;
        while (s < ls && t < lt){
            char cs = S.charAt(s);
            char ct = T.charAt(t);
            s++; t++;
            if (cs == ct){
                if (cs == '('){
                    open++;
                    System.out.print('(');
                }
                else if (open > 0){
                    open--;
                    System.out.print(")");
                }
                else{
                    System.out.print("()");
                }
            }
            else{
                System.out.print("()");
                if (cs == '('){
                    if (s < ls && S.charAt(s) == ')'){
                        s++;
                    }
                }
                else{
                    if (t < lt && T.charAt(t) == ')'){
                        t++;
                    }
                }
            }
        }
        if (s < ls){
            while (s <  ls){
                if (S.charAt(s) == '('){
                    open++;
                    System.out.print("(");
                }
                else if (open > 0){
                    open--;
                    System.out.print(")");
                }
                else{
                    System.out.print("()");
                }
                s++;
            }
        }
        else{
            while (t <  lt){
                if (T.charAt(t) == '('){
                    open++;
                    System.out.print("(");
                }
                else if (open > 0){
                    open--;
                    System.out.print(")");
                }
                else{
                    System.out.print("()");
                }
                t++;
            }
        }
        while (open > 0){
            System.out.print(")");
            open--;
        }
    }
}
