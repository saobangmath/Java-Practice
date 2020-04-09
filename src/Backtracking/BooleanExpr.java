package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BooleanExpr {
    public static boolean eval(String expr) {
        if (expr.equals("True")){
            return true;
        }
        else if (expr.equals("False")){
            return false;
        }
        else{
            int l = expr.length();
            int i, beg = 1, open = 0;
            List<Boolean> all = new ArrayList<>();
            String op = expr.substring(l - 4, l - 1);
            for (i = 1; i < l - 4; i++){
                char ch = expr.charAt(i);
                if (ch == '('){
                    open++;
                }
                else if (ch == ')'){
                    open--;
                }
                else if (ch ==',' && open == 0){
                    all.add(eval(expr.substring(beg, i)));
                    beg = i + 1;
                }
            }
            return compute(all, op);
        }
    }
    public static boolean compute(List<Boolean> all, String op){
        int l = all.size();
        if (op.equals("NOT")){
            return !all.get(0);
        }
        else if (op.equals("AND")){
            for (Boolean au : all){
                if (au == false){
                    return false;
                }
            }
            return true;
        }
        else if (op.equals("OR")){
            for (Boolean au : all){
                if (au == true){
                    return true;
                }
            }
            return false;
        }
        else{
            boolean result = all.get(0);
            for (int i = 1; i < l; i++){
                result ^= all.get(i);
            }
            return result;
        }
    }
    public static void main(String[] args) {
        String expr =  "((True,(False,NOT),True,AND),(True,NOT),XOR)";
        System.out.println(eval(expr));
    }
}
