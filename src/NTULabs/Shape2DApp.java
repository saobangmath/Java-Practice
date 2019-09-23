package NTULabs;

public class Shape2DApp{
    public static void main(java.lang.String[] args) {
        Circle c1 = new Circle(10);
        Triangle t1 = new Triangle(20, 25);
        Rectangle r1 = new Rectangle(50, 20);
        double res = c1.getArea() + t1.getArea() + r1.getArea();
        System.out.println("The total area of our sets is " + res);
    }
}
