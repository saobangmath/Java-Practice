package Backtracking;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class TwoBoxesWithSameNoDistinctBalls {
    static BigDecimal total = new BigDecimal(0);
    static BigDecimal cnt = new BigDecimal(0);
    static BigDecimal[] fact = new BigDecimal[25];
    public static double getProbability(int[] balls) {
        int n = balls.length;
        int d[] = new int[n];
        //System.out.println(cnt + " " + total);
        fact[0] = new BigDecimal(1);
        for (int i = 1; i <= 24;i++){
            fact[i] = fact[i - 1].multiply(new BigDecimal(i));
        }
        dfs(0, d, balls, 0);
        return cnt.divide(total, 7, RoundingMode.CEILING).doubleValue();
    }
    public static void dfs(int i, int[] d, int[] balls, int s){
        int n = d.length;
        if (i == n){
            if (s == 0) {
                int diff = 0;
                int left = 0;
                BigDecimal det = new BigDecimal(1);
                BigDecimal num;
                for (int j = 0; j < n; j++) {
                    if (d[j] == -balls[j]) diff--;
                    else if (d[j] == balls[j]) diff++;
                    int x = (d[j] + balls[j]) / 2;
                    int y = (balls[j] - x);
                    BigDecimal u = fact[x];
                    BigDecimal v = fact[y];
                    det = det.multiply(u); det = det.multiply(v);
                    left += x;
                }
                num = fact[left].multiply(fact[left]);
                BigDecimal au = num.divide(det);

                if (diff == 0) {
                    cnt = cnt.add(au);
                }
                total = total.add(au);
            }
        }
        else{
            for (int set = -balls[i]; set <= balls[i]; set += 2){
                d[i] = set;
                dfs(i + 1, d, balls, s + set);
            }
        }
    }
    public static void main(String[] args) {
        int[] balls = new int[]{6,6,6,6,6,6,6,6};
        System.out.println(getProbability(balls));
    }
}
