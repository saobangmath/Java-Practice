package HashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class QueenAttack{
//    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles){
//        HashMap<ArrayList<Integer>, Boolean> hm = new HashMap<>();
//        for(int[] p : obstacles){
//            hm.put(new ArrayList(Arrays.asList(p)), true);
//        }
//        return row(n, r_q, c_q, hm) +
//                col(n, r_q, c_q, hm) +
//                diag(n,r_q, c_q, hm);
//    }
//    static int row(int n, int r_q, int c_q, HashMap<int[],Boolean>hm){
//        int count = 0;
//        for (int col = c_q + 1; col <= n; col++){
//            if ()break;
//            else count++;
//        }
//        for (int col = c_q - 1; col >= 1; col--){
//            int[] pairs = {r_q, col};
//            if (check(hm,pairs))break;
//            else count++;
//        }return count;
//    }
//    static int col(int n, int r_q, int c_q, HashMap<int[], Boolean>hm){
//        int count = 0;
//        for (int row = r_q - 1; row >= 1; row -- ){
//            int[] pairs = {row, c_q};
//            if (check(hm,pairs)) break;
//            else count++;
//        }
//        for (int row = r_q + 1; row <= n; row ++ ){
//            int[] pairs = {row, c_q};
//            if (check(hm,pairs)) break;
//            else count++;
//        }return count;
//    }
//    static int diag(int n, int r_q, int c_q, HashMap<int[],Boolean>hm){
//        int count = 0;
//        int new_r = r_q + 1;
//        int new_c = c_q + 1;
//        while (new_r <= n && new_c <= n){
//            int[] pairs = {new_r, new_c};
//            if (check(hm,pairs)) break;
//            else count++;
//            new_r ++;
//            new_c ++;
//        }
//        new_r = r_q - 1;
//        new_c = c_q - 1;
//        while (new_r >=1 && new_c >= 1){
//            int[] pairs = {new_r, new_c};
//            if (check(hm,pairs)) break;
//            else count++;
//            new_r --;
//            new_c --;
//        }
//        new_r = r_q - 1;
//        new_c = c_q + 1;
//        while (new_r >= 1 && new_c <= n){
//            int[] pairs = {new_r, new_c};
//            if (check(hm,pairs)) break;
//            else count++;
//            new_r --;
//            new_c ++;
//        }
//        new_r = r_q + 1;
//        new_c = c_q - 1;
//        while (new_r <= n && new_c >= 1){
//            int[] pairs = {new_r, new_c};
//            if (check(hm,pairs)) break;
//            else count++;
//            new_r ++;
//            new_c --;
//        }
//        return count;
//    }
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0]);
//
//        int k = Integer.parseInt(nk[1]);
//
//        String[] r_qC_q = scanner.nextLine().split(" ");
//
//        int r_q = Integer.parseInt(r_qC_q[0]);
//
//        int c_q = Integer.parseInt(r_qC_q[1]);
//
//        int[][] obstacles = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            String[] obstaclesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 2; j++) {
//                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
//                obstacles[i][j] = obstaclesItem;
//            }
//        }
//
//        int result = queensAttack(n, k, r_q, c_q, obstacles);
//
//        System.out.println(result);
//
//        scanner.close();
//    }
}
