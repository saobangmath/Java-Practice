package Tutorial_3_CZ2002;

public class Cylinder extends Circle{
    int height;
    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double area() {
        return super.area() * 2 + 2 * PI * getRadius() * getHeight();
    }
    public  double volumn(){
        return PI * super.area() * getHeight();
    }
}
