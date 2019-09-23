package NTULabs;

public class Circle extends Shape{
    double radius;
    public static double PI = 3.14;
    public Circle(double radius){
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getArea() {
        return PI * this.radius * this.radius;
    }

    @Override
    public double getTotalSurfaceArea() {
        return this.getArea() * 4;
    }
}
