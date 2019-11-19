package Advanced_Data_Structure;

import java.util.Arrays;

public class FenwichTree {
    public static void main(String[] args) {
        int[] freq = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] BTTree =  constructBITree(freq);
        System.out.println(getSum(BTTree, 5));
        freq[3] += 6;
        update(BTTree, 3, 6);
        System.out.println(getSum(BTTree, 5));
    }
    // find sum of the subarray from 0 to index
    public static int getSum(int[] BITree, int index){
        int sum = 0;
        index = index + 1;
        while (index > 0){
            sum += BITree[index];
            // find the ancestor of the index node which result from removing the last setbit
            index = index - (index & (-index));
        }
        return sum;
    }

    public static  void update(int[] BITree, int index, int val){
        int n = BITree.length;
        index = index + 1;
        while (index <= n){
            BITree[index] += val;
            index = index + (index &(-index));
        }
    }
    static int[] constructBITree(int arr[]){
        int BITree[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++){
            update(BITree, i, arr[i]);
        }
        return BITree;
    }
}
