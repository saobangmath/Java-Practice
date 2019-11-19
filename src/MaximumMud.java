import java.util.Scanner;

public class MaximumMud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos[] = new int[n];
        int height[] = new int[n];
        for (int i = 0; i < n; i++){
            pos[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            height[i] = sc.nextInt();
        }
        System.out.println(MaximumMudResult(height, pos));
    }

    private static int MaximumMudResult(int[] height, int[] pos) {
        int res = -1;
        for (int i = 0; i < height.length - 1; i++){
            int dist = Math.abs(height[i + 1] - height[i]);
            if ((pos[i + 1] - pos[i] + dist) / 2 > res){
                res = (pos[i + 1] - pos[i] + dist);
            }
        }
        return (res == -1)? 0 : res;
    }
}
