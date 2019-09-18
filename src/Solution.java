import java.io.*;
import java.util.*;


public class Solution {
    boolean check(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    // Complete the abbreviation function below.
    String abbreviation(String a, String b) {
        boolean mark[][] = new boolean[a.length() + 1][b.length() + 1];
        mark[0][0] = true;
        for (int i = 1; i <= a.length(); i++) {
            if (check(a.charAt(i - 1))) {
                mark[i][0] = false;
            } else {
                mark[i][0] = mark[i - 1][0];
            }
        }
        for (int i = 1; i <= b.length(); i++) {
            mark[0][i] = false;
        }
        for (int x = 1; x <= b.length(); x++) {
            for (int y = 1; y <= a.length(); y++) {
                if (b.charAt(x - 1) == a.charAt(y - 1)) { // 2 upper character
                    mark[y][x] = mark[y - 1][x - 1];
                } else if (check(a.charAt(y - 1))) { // a upper character but not that of b
                    mark[y][x] = false;
                } else {
                    char au = Character.toUpperCase(a.charAt(y - 1));
                    if (au == b.charAt(x - 1)) {
                        mark[y][x] = mark[y - 1][x - 1] || mark[y - 1][x];
                    } else {
                        mark[y][x] = mark[y - 1][x];
                    }
                }
            }
        }
        return mark[a.length()][b.length()] ? "YES" : "NO";
    }

    private final Scanner scanner = new Scanner(System.in);

    public void main(ReverseString[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);

        }

        bufferedWriter.close();

        scanner.close();
    }
}




