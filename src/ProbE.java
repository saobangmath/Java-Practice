import java.util.Scanner;

public class ProbE {
    public static String sum(String s1, String s2){
        String r = "";
        int add = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        while (i >= 0 && j >= 0){
            int c1 = s1.charAt(i) - '0';
            int c2 = s2.charAt(j) - '0';
            int t = (c1 + c2 + add);
            r = (t % 10) + r;
            add = (t >= 10) ? 1 : 0;
            i--;
            j--;
        }
        if (i >= 0){
            while (i >= 0){
                int c1 = s1.charAt(i) - '0';
                int t = c1 + add;
                add = (t >= 10) ? 1 : 0;
                r = (t % 10) + r;
                i--;
            }
        }
        else{
            while (j >= 0){
                int c2 = s2.charAt(j) - '0';
                int t = c2 + add;
                add = (t >= 10) ? 1 : 0;
                r = (t % 10) + r;
                j--;
            }
        }
        if (add > 0){
            r = add + r;
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int N = sc.nextInt();
        String s = ""; // store value dd...d * d - N d 's
        String r = "";
        int add = 0;
        for (int i = 0; i < N; i++){
            int x = d * d + add;
            s = (x % 10) + s;
            add = (x / 10);
        }
        if (add > 0){
            s =  add + s;
        }

        for (int i = 0; i < N; i++){
            r = sum(r, s);
            s = s + "0";
        }
        System.out.println(r);
    }
}
