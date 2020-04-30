import java.io.*;
import java.util.*;
public class Solver {
    static int[]a = new int[100000];
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k, i;
        String nk[] = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        int c = 0;
        hm.put("1110111", 0);
        hm.put("0010010", 1);
        hm.put("1011101", 2);
        hm.put("1011011", 3);
        hm.put("0111010", 4);
        hm.put("1101011", 5);
        hm.put("1101111", 6);
        hm.put("1010010", 7);
        hm.put("1111111", 8);
        hm.put("1111011", 9);
        boolean mark = true;
        for (i = 0; i < n; i++){
            String in = br.readLine();
            c += countZero(in);
            a[i] = hm.get(in);
        }
        if (c > k || mark){
            System.out.println(-1);
            return;
        }

    }
    public static int countZero(String s){
        int r = 0;
        for (int i = 0; i < 7; i++){
            if (s.charAt(i) == '0'){
                r++;
            }
        }
        return r;
    }
}
