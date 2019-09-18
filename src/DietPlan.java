public class DietPlan {
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int r = 0;
        int cur_sum = 0;
        int beg = 0, end = k-1;
        for (int i = beg; i < end; i++){
            cur_sum += calories[i];
        }
        while (end < calories.length){
            if (cur_sum < lower){
                r--;
            }
            else if (cur_sum > upper){
                r++;
            }
            cur_sum -= calories[beg++];
            cur_sum += calories[end++];
        }
        return r;
    }

    public static void main(ReverseString[] args) {

    }
}
