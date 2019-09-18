package Tutorial_2_CZ2002;

import java.util.Scanner;

public class CircleApp {
    public static void main(String[] args) {
        System.out.println("==== Circle Computation =====\n" +
                "|1. Create a new circle |\n" +
                "|2. Print Area |\n" +
                "|3. Print circumference |\n" +
                "|4. Quit |\n" +
                "=============================");
        boolean stop = false;
        Circle c = null;
        Scanner sc = new Scanner(System.in);
        while (!stop){
            System.out.println("Choose option (1-3):");
            int option = sc.nextInt();
            switch (option){
                case 1: // create new Circle
                    System.out.println("Enter the radius to compute the area and circumference");
                    double radius = sc.nextDouble();
                    c = new Circle(radius);
                    System.out.println("A new circle is created");
                    break;
                case 2:
                    c.printArea();
                    break;
                case 3:
                    c.printCircumference();
                    break;
                default:
                    System.out.println("Thank you!!");
                    stop = true;
            }
        }
        sc.close();
    }
}
