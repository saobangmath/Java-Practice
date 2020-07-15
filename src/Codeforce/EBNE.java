package Codeforce.div2;

import java.util.Scanner;

public class EBNE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++){
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(f(s));
        }
    }
    public static String f(String s){
        int l = s.length(), end = l - 1;
        while (end >= 0){
            if ((s.charAt(end) - '0') % 2 == 1){
                break;
            }
            else{
                end--;
            }
        }
        if (end < 0){
            return "-1";
        }
        else{
            for (int i = 0; i < end; i++){
                if ((s.charAt(i) - '0') % 2 == 1){
                    return s.charAt(i) + "" +  s.charAt(end);
                }
            }
        }
        return "-1";
    }
}
