package Implementations;

import java.io.*;

public class MedianString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int add = 0;
        String s = br.readLine();
        String t = br.readLine();
        int[] a = new int[n + 1];
        for (int i = n; i >= 1; i--){
            int x = (s.charAt(i - 1) - 'a') +(t.charAt(i - 1) - 'a') + add;
            a[i] = x % 26;
            add = (x >= 26 ? 1 : 0);
        }
        a[0] = add;
        for (int i = 1; i <= n; i++){
            a[0] = a[0] * 26 + a[i];
            System.out.print((char)(a[0] / 2 + 'a'));
            a[0] = (a[0] % 2);
        }
    }
}
