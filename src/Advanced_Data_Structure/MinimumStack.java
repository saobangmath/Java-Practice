package Advanced_Data_Structure;

import java.util.ArrayList;
import java.util.Stack;

public class MinimumStack {
    private Stack<Integer> min_stack;
    private int cur_min;
    public MinimumStack(){
        min_stack = new Stack<>();
        cur_min = Integer.MAX_VALUE;
    }
    /**
     * minimum stack function -> return the list of all minimum call to the current stack.
     * required to master the minimum details!!
     * **/
    int[] minimumOnStack(String[] operations){
        ArrayList<Integer> l = new ArrayList<>();
        for (String op : operations){
            if (op.length() >= 4){ // push sth
               int au = Integer.parseInt(op.substring(5));
               if (min_stack.isEmpty()){ // no element in the stack yet!!
                   min_stack.push(au);
                   cur_min = au;
               }
               else{
                   if (au >= cur_min){ // if the push element is not the minimum element -> merely push to the stack.
                       min_stack.push(au);
                   }
                   else{ // else create another element = (2 * au - cur_min), push to the stack, then update  the minimum element.
                       // compare to the ordinary push the au variable --> this element still < the LAST cur_min, then also assisting in retrieving the LAST cur_min when needed.
                       int temp = 2 * au - cur_min;
                       min_stack.push(temp);
                       //update cur_min
                       cur_min = au;
                   }
               }
            }
            else if (op.equals("pop")){ // pop
                int top = min_stack.peek();
                min_stack.pop();
                if (top > cur_min){ // if the top element merely more than the cur_min one, then it is not affect the current minimum;
                    continue;
                }
                else{
                    cur_min = 2 * cur_min - top; // else retrieving back the PREVIOUS cur_min value
                }
            }
            else{ // min
                l.add(cur_min);
            }
        }
        int s = l.size();
        int[] res = new int[s];
        for (int i = 0; i < s; i++){
            res[i] = l.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        MinimumStack minimumStack = new MinimumStack();
        String[] operations = new String[]{"push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"};
        int[] list = (minimumStack.minimumOnStack(operations));
        for (int num : list){
            System.out.print(num + " ");
        }
    }
}
