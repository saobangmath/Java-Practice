import java.util.ArrayList;
import java.util.List;

public class IntervalTree {

    static public class Interval{
        int low, high;
        public Interval(int low, int high){
            this.low = low;
            this.high = high;
        }
    }

    public static class ITNode{
        Interval i;
        ITNode left, right;
        public ITNode(Interval i, ITNode left, ITNode right){
            this.i = i;
            this.left = left;
            this.right = right;
        }
    }

    static ITNode insert(ITNode root, Interval i){
        if (root == null){
            return new ITNode(i, null,null);
        }
        else{
            int l = root.i.low;
            if (i.low <= l){
                root.left = insert(root.left, i);
            }
            else {
                root.right = insert(root.right, i);
            }
            return root;
        }
    }
    static void bfs(int[] count, ITNode root, int target){
        if (root == null){
            return;
        }
        else{
            if (root.i.high >= target && target >= root.i.low){
                ++count[target];
            }
            bfs(count, root.left, target);
            if (root.i.low < target){
                bfs(count, root.right, target);
            }
        }
    }
    static int[][] blockStorageRewrites(int blockCount, int[][] writes, int threshold) {
        ITNode root = null;
        int[] count = new int[blockCount];
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < writes.length; i++){
            root = insert(root, new Interval(writes[i][0], writes[i][1]));
        }
        for (int i = 0; i < blockCount; i++){
            bfs(count, root,i);
        }
        int beg = 0, end = 0;
        while (beg < blockCount){
            while (beg < blockCount && count[beg] < threshold) {
                ++beg;
            }

            end = beg;

            while (end < blockCount && count[end] >= threshold) {
                ++end;
            }

            int[] num = new int[2];
            if (end - 1 >= beg){
                num[0] = beg;
                num[1] = end - 1;
                l.add(num);
            }

            beg = end;
        }
        int[][] res = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++){
            res[i] = l.get(i);
        }
        return res;
    }
    public static void main(ReverseString[] args) {
        int blockCount = 7;
        int[][]writes = {{1,1},
                        {1,2},
                        {1,3},
                        {1,4},
                        {1,5},
                        {5,6},
                        {6,6},
                        {6,6}};
        int threshold = 3;
        int[][] res = (blockStorageRewrites(blockCount,writes, threshold));
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}