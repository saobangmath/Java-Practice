package Dynamic_Programming;

import java.util.Scanner;

public class RegExpMatching {
    public static  boolean isMatch(String s, String p){
        int ls = s.length();
        int lp = p.length();
        boolean dp[][] = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
        for (int i = 1; i <= ls; i++){
            for (int j = 1; j <= lp; j++){
                char chp = p.charAt(j - 1);
                char chs = s.charAt(i - 1);
                if (chp == chs || chp == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (chp == '*') {
                    if (j >= 2){
                        char ch = p.charAt(j - 2);
                        if (ch == '.'){
                            dp[i][j] = true;
                        }
                        else if (ch == '*'){
                            dp[i][j] = dp[i][j - 1];
                        }
                        else{
                            dp[i][j] = false;
                        }
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        for (int j = 1; j <= lp; j++){
            if (dp[ls][j]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(isMatch(s, p));
    }
}
