package Greedy;

import java.util.ArrayList;

public class LargestMonotonous {
    public static void main(String[] args) {
        int N = 1000;
        System.out.println(monotoneIncreasingDigits(N));
    }
    public static int monotoneIncreasingDigits(int N) {
        String str = N + "";
        int no = str.length();
        int[] digits = new int[no];
        for (int i = 0; i < no; i++){
            digits[i] = str.charAt(i) - '0';
        }
        int end_point = 0;
        while (end_point < no - 1){
            if (digits[end_point] <= digits[end_point+ 1]){
                end_point++;
            }
            else{
                break;
            }
        }
        if (end_point == no - 1){
            return N;
        }
        else{
            int r = 0;
            for (int i = end_point + 1; i < no; i++){
                digits[i] = 9;
            }
            while (end_point >= 0){
                --digits[end_point];
                if (end_point > 0 && digits[end_point] < digits[end_point - 1]){
                    digits[end_point] = 9;
                    --end_point;
                }
                else{
                    break;
                }
            }
            for (int i = 0; i < digits.length; i++){
                r = r * 10 + digits[i];
            }
            return r;
        }
    }
}
