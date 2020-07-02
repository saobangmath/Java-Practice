package Advanced_Data_Structure;

import java.util.Queue;

public class SparseTable {
    public int arr[];
    public int[][] sumLookUp; // sum from subArray start with i and (1 << j) elements;
    public int[][] miniLookup; // index of minimum number in of subArray start with i and (1 << j) elements;
    public SparseTable(int arr[], int n){
        this.arr = arr;
        this.sumLookUp = new int[n][16];
        this.miniLookup = new int[n][16];
        for (int i = 0; i < n; i++){
            sumLookUp[i][0] = arr[i];
            miniLookup[i][0] = i;
        }
        for (int j = 1; (1 << j) <= n; j++){
            for (int i = 0; (i + (1 << j) - 1) < n; i++){
                if (arr[miniLookup[i][j - 1]] < arr[miniLookup[i + (1 << (j - 1))][j - 1]]){
                    miniLookup[i][j] = miniLookup[i][j - 1];
                }
                else{
                    miniLookup[i][j] = miniLookup[i + (1 << (j - 1))][j - 1];
                }
                sumLookUp[i][j] = sumLookUp[i][j - 1] + sumLookUp[i + (1 << (j - 1))][j - 1];
            }
        }
    }
    public int RMQ(int L, int R){
        int j = (int)(Math.log(R - L + 1));
        if (this.arr[miniLookup[L][j]] <= this.arr[miniLookup[R - (1 << j) + 1][j]]){
            return this.arr[miniLookup[L][j]];
        }
        else{
            return this.arr[miniLookup[R -(1 << j) + 1][j]];
        }
    }
    public long SUM(int L, int R){
        long answer = 0;
        while (L <= R){
            int j = (int)(Math.log(R - L + 1));
            answer += this.sumLookUp[L][j];
            L = L + (1 << j);
        }
        return answer;
    }
    static class Query{
        public int L, R;
        public Query(int L, int R){
            this.L = L;
            this.R = R;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{7, 2, 3, 0, 5, 10, 3, 12, 18};
        int n = arr.length;
        SparseTable spTable = new SparseTable(arr, n);
        Query[] q = {new Query(0, 4),
                     new Query(4, 7),
                     new Query(0, 8)};
        for (int i = 0; i < q.length; i++){
            System.out.println("Query for the range: [" +  q[i].L + ", " + q[i].R + "]: ");
            System.out.println("Minimum: " + spTable.RMQ(q[i].L, q[i].R));
            System.out.println("Sum: " + spTable.SUM(q[i].L, q[i].R));
        }
    }
}
