package Greedy;

import java.util.Scanner;

public class ProfitMaximization {
    public static int maxProfit(int[] prices) {
        int peak = prices[0], valley = prices[0];
        int i = 0;
        int maxProfit = 0;
        while (i < prices.length - 1){
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i]; // catch up the valley
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxProfit += (peak - valley);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for (int i = 0 ; i < n ; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
    }
}
