import java.util.ArrayList;
import java.util.HashMap;

public class SquarefulArray {
    int ans;
    public SquarefulArray(){
        this.ans = 0;
    }
    public int numSquarefulPerms(int[] A) {
        int ans = 0 ;
        HashMap<Integer, ArrayList<Integer>>map = new HashMap<>();
        HashMap<Integer,Boolean>trace = new HashMap<>();
        boolean[] mark = new boolean[A.length];
        for (int i = 0; i < A.length; i++){
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A.length; j++){
                if (check(A[i] + A[j]) && i != j){
                    ArrayList<Integer> l = map.get(i);
                    l.add(j);
                    map.put(i,l);
                }
            }
        }
        for (int i = 0; i < mark.length; i++){
            if (!trace.containsKey(A[i]))
            {
                dfs(A,map,mark,1,i);
                trace.put(A[i], true);
            }
        }
        return this.ans;
    }

    public void dfs(int[] A,HashMap<Integer,ArrayList<Integer>>map,boolean[] mark, int l,int src){
        HashMap<Integer,Boolean>trace = new HashMap<>();
        if (l == mark.length){
            this.ans++;
        }
        else{
            mark[src] = true;
            ArrayList<Integer> pair = map.get(src);
            for (int j: pair){
                if (!mark[j] && !trace.containsKey(A[j])){
                    mark[j] = true;
                    trace.put(A[j],true);
                    dfs(A,map,mark,++l,j);
                    --l;
                    mark[j] = false;
                }
            }
            mark[src] = false;
        }
    }

    public static boolean check(int a){
        int sqrt = (int)(Math.sqrt(a));
        return a == sqrt * sqrt;
    }
    public static void main(ReverseString[] args) {
        int[] A = {2,2,7};
        SquarefulArray s = new SquarefulArray();
        System.out.println(s.numSquarefulPerms(A));
    }
}
