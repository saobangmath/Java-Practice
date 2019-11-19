package NTULabs;
import java.lang.String;

import static NTULabs.Circle.PI;

public class Shape3DApp {
    static Circle c1 = new Circle(10);;
    static Triangle t1 =  new Triangle(20, 25);
    static Rectangle r1 = new Rectangle(50, 20);
    public static void main(String[] args) {
//        double res = c1.getTotalSurfaceArea() + t1.getTotalSufaceArea() + r1.getTotalSurfaceArea();
//        System.out.println("The total area of our sets is " + res);
        SecondProbSolver();
        FirstProbSolver();
    }

    private static void FirstProbSolver() {
        double height = Math.sqrt(Math.pow(t1.getBase() / 2, 2) + Math.pow(t1.getHeight(), 2));
        double CircleSurfaceArea = c1.getArea() * 4;
        double PiramidSurfaceArea = (new Triangle(t1.getBase(), height)).getArea() * 4;
        double CuboidSurfacArea = r1.getArea() * 4;
        System.out.println("Total surface area of 3-D for the second prob is: " );
        System.out.println(CircleSurfaceArea + PiramidSurfaceArea + CuboidSurfacArea);
    }

    private static void SecondProbSolver() {
        double l = Math.sqrt(Math.pow(t1.getBase() / 2, 2) + Math.pow(t1.getHeight(), 2));
        double CircleSurfaceArea = c1.getArea() * 4;
        double ConeSurfaceArea = Math.PI * t1.getBase() * l;
        double CylinderSurfacArea = r1.getBreadth() * new Circle(t1.getBase()).getTotalSurfaceArea();
        System.out.println("Total surface area of 3-D for the third prob is: " );
        System.out.println(CircleSurfaceArea + ConeSurfaceArea + CircleSurfaceArea);
    }
}
