import java.util.Scanner;

public class COLORING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        boolean visited[][] = new boolean[w][h];
        int color = 0;
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            if (a == 1){
                for (int _x = 0; _x <= x - 1; _x++){
                    for (int _y = 0; _y <= h - 1; _y++){
                        if (!visited[_x][_y]) color++;
                        visited[_x][_y] = true;
                    }
                }
            }
            else if (a == 2){
                for (int _x = x; _x <= w - 1; _x++){
                    for (int _y = 0; _y <= h - 1; _y++){
                        if (!visited[_x][_y]) color++;
                        visited[_x][_y] = true;
                    }
                }
            }
            else if (a == 3){
                for (int _x = 0; _x <= w - 1; _x++){
                    for (int _y = 0; _y <= y - 1; _y++){
                        if (!visited[_x][_y]) color++;
                        visited[_x][_y] = true;
                    }
                }
            }
            else{
                for (int _x = 0; _x <= w - 1; _x++){
                    for (int _y = y; _y <= h - 1; _y++){
                        if (!visited[_x][_y]) color++;
                        visited[_x][_y] = true;
                    }
                }
            }
        }
        System.out.println((w * h) - color);
    }
}
