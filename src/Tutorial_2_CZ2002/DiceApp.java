package Tutorial_2_CZ2002;

import java.util.Random;

public class DiceApp {
    public static void main(String[] args) {
        System.out.println("----jGRASP exec: java DiceApp");
        Random rand = new Random();
        System.out.println("Press <key> to roll the first dice");
        int first = rand.nextInt(6) + 1;
        System.out.println("Current Value is " + first);
        System.out.println("Press <key> to roll the second dice");
        int second = rand.nextInt(6) + 1;
        System.out.println("Current Value is " + second);
        System.out.println("Your total number is: " + (first + second));
    }
}
