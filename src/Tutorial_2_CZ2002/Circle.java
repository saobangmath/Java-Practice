package Tutorial_2_CZ2002;

import java.sql.SQLOutput;

public class Circle {
    private double radius;
    private static final double PI = 3.14159;

    public Circle(double rad){
        this.radius = rad;
    }

    public void setRadius(double rad){
        this.radius = rad;
    }
    public double getRadius(){
        return this.radius;
    }
    public double area(){
        return  PI * Math.pow(this.radius,2);
    }
    public double circumference(){
        return 2 * PI * this.radius;
    }
    public void printArea(){
        System.out.println("Area of circle");
        System.out.println("Radius: " + this.getRadius());
        System.out.println("Area: " + this.area());
    }
    public void printCircumference(){
        System.out.println("Circumference of circle");
        System.out.println("Radius: " + this.getRadius());
        System.out.println("Circumference: " + this.circumference());
    }
}
