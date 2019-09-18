package Tutorial_5_CZ2002;


public class TestPolygon {
    public static void printArea(Polygon polygon){
        System.out.println("Area = ");
    }
    public static void printArea(Triangle triangle){
        System.out.println("Area = " + triangle.calArea());
    }
    public static void printArea(Rectangle rectangle){
        System.out.println("Area = " + rectangle.calArea());
    }

    public static void main(String[] args) {
        Polygon triangle = new Triangle("",3,4);
        Polygon rect = new Rectangle("",5,6);

        printArea((Triangle) triangle);
        printArea((Rectangle) rect);
    }
}
