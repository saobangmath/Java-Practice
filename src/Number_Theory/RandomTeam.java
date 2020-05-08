package Number_Theory;

import java.util.Scanner;

/**
 * @author Tran Anh Tai
 * Problem: let 2 integer n, m corresponding to the number of people and the total groups.
 * divided those people in such m group such that at group has at least 1 person;
 * For each division, all the people in each group become friends tgt;
 * Or the prob transform into let x1, x2, ...., xm: sigma(xi) = n;
 * Find the maximum and minimum value of sigma(xi^2);
 * The maximum occurs when xi = 1 for i in range(1, m - 1), x(m) = (n - (m - 1);
 * The minimum occurs when there is no xi with the different at least 2;
 * Let a number has value x; b number has value x + 1;
 * a + b = m;
 * a * x +  b * (x + 1) = n;  <-> m * x + b = n; -> b should be the remainder n mod m;
 */
public class RandomTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long max, min;
        // max handling;
        max = (long)1 * (n - (m - 1)) * (n - (m - 1) - 1) / 2;
        long b = n % m;
        long x = n / m;
        // min handling
        min = ((m - b) * x * x + b * (x + 1) * (x + 1) - n) / 2;
        System.out.println(min + " " + max);
    }
}
