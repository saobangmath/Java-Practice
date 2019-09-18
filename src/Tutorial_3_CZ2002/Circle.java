package Tutorial_3_CZ2002;

public class Circle extends Point{
    int x,y;
    int radius;
    static final double PI = 3.14;
    public Circle(int x, int y, int radius){
        super(x,y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public double area(){
        return PI * Math.pow(getRadius(),2);
    }
}
