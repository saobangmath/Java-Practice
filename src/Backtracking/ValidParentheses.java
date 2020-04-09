package Backtracking;

import java.util.*;

public class ValidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        ArrayList<String> res = new ArrayList<>();

        ArrayList<Map<Integer, Boolean>> indexes = new ArrayList<>(); // index set of ( which each set will eliminate 1 index;
        Map<Integer, Boolean> open = new HashMap<>(); // position of those (
        Map<Integer, Boolean> close = new HashMap<>(); // position of those )

        int l = s.length();
        int i = 0, track = 0;
        while (i < l){
            char c = s.charAt(i);
            if (c == '('){
                open.put(i, true);
                track++;
            }
            else if (c == ')'){
                track--;
                if (track >= 0){
                    close.put(i, true);
                }
                else{
                    close.clear();
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "()())";
        System.out.println(removeInvalidParentheses(s));
    }
}
