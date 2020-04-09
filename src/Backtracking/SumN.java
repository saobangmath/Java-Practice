package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum, nxt;
        List<List<Integer>>[] dp = new ArrayList[n + 1];
        for (sum = 1; sum <= n - 1; sum++){
            // next choosen number
            dp[sum] = new ArrayList<>();
            List<Integer> oneElement = new ArrayList<>();
            oneElement.add(sum);
            dp[sum].add(oneElement);
            for (nxt = 1; nxt < sum; nxt++){
                List<List<Integer>> all = dp[sum - nxt];
                for (List<Integer> l : all){
                    if (l.get(l.size() - 1) <= nxt){
                        ArrayList<Integer> new_list = new ArrayList<>();
                        new_list.addAll(l);
                        new_list.add(nxt);
                        dp[sum].add(new_list);
                    }
                }
            }
        }
        // consider sum == n;
        for (nxt = 1; nxt < n; nxt++){
            List<List<Integer>> all = dp[n - nxt];
            for (List<Integer> l : all){
                int s =l.size();
                if (l.get(s - 1) <= nxt){
                    for (int num : l){
                        System.out.print(num + " ");
                    }
                    System.out.println(nxt + " ");
                }
            }
        }
        System.out.println(n);
    }
}
