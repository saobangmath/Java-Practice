package Dynamic_Programming;

public class Hierachy {
    static int MOD = 1000000007;
    public static void getCofactor(long[][] mat, long[][] temp, int p, int q, int n){
        int i = 0, j = 0;
        int row, col;
        for (row = 0; row < n; row++){
            for (col = 0; col < n; col++){
                if (row != p && col != q){
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1){
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    static int determinantOfMatrix(long mat[][], int n)
    {
        long num1, num2, det = 1, total = 1; // Initialize result
        int index;
        // temporary array for storing row
        long []temp = new long[n + 1];

        // loop for traversing the diagonal elements
        for(int i = 0; i < n; i++)
        {
            index = i; // initialize the index

            // finding the index which has non zero value
            while(mat[index][i] == 0 && index < n)
            {
                index++;

            }
            if(index == n) // if there is non zero element
            {
                // the determinat of matrix as zero
                continue;

            }
            if(index != i)
            {
                // loop for swaping the diagonal element row and index row
                for(int j = 0; j < n; j++)
                {
                    swap(mat, index, j, i, j);
                }
                // determinant sign changes when we shift rows
                // go through determinant properties
                det = ((det * (index % 2 ==  i % 2 ? 1 : -1)) % MOD);
            }

            // storing the values of diagonal row elements
            for(int j = 0; j < n; j++)
            {
                temp[j] = mat[i][j];

            }

            // traversing every row below the diagonal element
            for(int j = i + 1; j < n; j++)
            {
                num1 = temp[i]; // value of diagonal element
                num2 = mat[j][i]; // value of next row element

                // traversing every column of row
                // and multiplying to every row
                for(int k = 0; k < n; k++)
                {

                    // multiplying to make the diagonal
                    // element and next row element equal
                    mat[j][k] = ((num1 * mat[j][k]) - (num2 * temp[k])) % MOD;
                    while (mat[j][k] < 0){
                        mat[j][k] += MOD;
                    }
                }
                total = (total * num1) % MOD; // Det(kA)=kDet(A);
            }

        }
        // mulitplying the diagonal elements to get determinant
        for(int i = 0; i < n; i++)
        {
            det = (det * mat[i][i]) % MOD;
            det = (det + MOD) % MOD;
        }
        return (int)((det * power(total, MOD - 2, MOD)) % MOD); // Det(kA)/k=Det(A);
    }

    static long[][] swap(long [][]arr, int i1, int j1, int i2, int j2)
    {
        long temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
        return arr;
    }
    static long power(long x, long y, int m)
    {
        if (y == 0)
            return 1;

        long p = power(x, y / 2, m);
        p = (p * p) % m;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % m;
    }
    public static int hierarchiesCount(int n, int [][] respectList){
        long[][] mat = new long[n][n];
        long[][] au = new long[n - 1][n - 1];
        for (int[] resp : respectList){
            int x = resp[0];
            int y = resp[1];
            mat[x][x]++;
            mat[y][y]++;
            mat[y][x] = mat[x][y] = -1;
        }
        getCofactor(mat, au, 0, 0, n);
        int result = ((determinantOfMatrix(mat, n - 1) * n) % MOD);
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] respectList = {{7,3},{7,0},{0,1},{7,9}, {9,6},{6,5},{5,4},{7,2},{1,8},{1,4},{2,4},{0,4},{1,5},{8,3},{8,9},{5,2},{2,6},{9,0},{6,7},{6,1},{3,0}};
        System.out.println(hierarchiesCount(n, respectList));
    }
}
