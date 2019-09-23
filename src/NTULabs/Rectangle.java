package NTULabs;

public class Rectangle extends Shape {
    private double length, breadth;
    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public double getLength() {
        return this.length;
    }

    public double getBreadth() {
        return this.breadth;
    }

    @Override
    public double getArea() {
        return this.length * this.breadth;
    }

    @Override
    public double getTotalSurfaceArea() {
        return this.getArea() * 2 + this.breadth * this.length * 4;
    }
}
