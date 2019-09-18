public class prime {
    static int MOD = 1000000007;
    public static int numPrimeArrangements(int n) {
        boolean[] mark = new boolean[n+1];
        mark[1] = true;
        long  r = 1;
        int count =  0;
        for (int i = 1; i <= n; i++){
            if (!mark[i]){
                count++;
                for(int j = i; j <= n;j+=i){
                    mark[j] = true;
                }
            }
        }
        for (int i = 1; i <= count; i++){
            r = (r * i ) % MOD;
        }
        for (int i = 1; i <= n - count; i++){
            r = (r * i ) % MOD;
        }
        return (int)(r % MOD);
    }

    public static void main(ReverseString[] args) {
        int n = 100;
        System.out.println(numPrimeArrangements(n));
    }
}
