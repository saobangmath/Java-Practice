package Competitive_Programming;

import java.util.Scanner;
public class BeautifulInteger {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int last = -1;
        String s = sc.next();
        int num[] = new int[n];
        int fit[] = new int[k];
        for (int i = 0; i < n; i++){
            num[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < k ; i++){
            fit[i] = num[i];
            for (int j = i; j < n; j += k){
                if (num[i] < num[j]){
                    fit[i] = num[i] + 1;
                    last = i;
                    if (i > 0){
                        fit[i - 1]--;
                    }
                    break;
                }
            }
        }
        if (last != -1){
            for (int i = last + 1; i < k; i++){
                fit[i] = 0;
            }
        }
        System.out.println(n);
        for (int i = 0; i < n; i++){
            System.out.print(fit[i % k]);
        }
    }
}
