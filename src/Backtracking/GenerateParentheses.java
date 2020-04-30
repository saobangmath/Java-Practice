package Backtracking;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 4;
        String result[] = (generator(n));
        for (String s :result){
            System.out.println(s);
        }
    }

    private static String[] generator(int n) {
        List<String> au = new ArrayList<>();
        backtrack(au, n, n, "");
        int l = au.size();
        String[] result = new String[l];
        for (int i = 0; i < l; i++){
            result[i] = au.get(i);
        }
        return result;
    }

    private static void backtrack(List<String> result, int open, int close, String s) {
        if (open == 0){
            String au = "";
            for (int i = 0; i < close; i++){
                au += ')';
            }
            result.add(s + au);
        }
        else{
            backtrack(result,open - 1, close, s + '(');
            if (close > open){
                backtrack(result, open, close - 1, s + ')');
            }
        }
    }
}
