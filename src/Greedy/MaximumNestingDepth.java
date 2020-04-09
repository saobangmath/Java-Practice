package Greedy;

import java.util.Stack;

public class MaximumNestingDepth {
    public static void main(String[] args) {
        String seq = "()(())()()";
        int[] ans = maxDepthAfterSplit(seq);
        for (int i = 0; i < seq.length(); i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static class X{
        public int i, color;
        public X(int i, int color){
            this.i = i;
            this.color = color;
        }
    }
    public static int[] maxDepthAfterSplit(String seq) {
        int l = seq.length(), i;
        int color = 0;
        int[] ans = new int[l];
        Stack<X> st = new Stack<>();
        for (i = 0; i < l; i++){
            char ch = seq.charAt(i);
            if (ch == '('){
                st.push(new X(i, color));
                color = 1 - color;
            }
            else{
                X top = st.pop();
                ans[i] = ans[top.i] = top.color;
                if (!st.isEmpty()) {
                    X next = st.peek();
                    color = 1 - next.color;
                }
            }
        }
        return ans;
    }
}
