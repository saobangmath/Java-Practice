package NTULabs;

public class Triangle extends Shape{
    private double base, height;
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double getArea() {
        return this.base * this.height / 2;
    }

    @Override
    public double getTotalSurfaceArea() {
        //TODO finish!
        return 0;
    }
}
