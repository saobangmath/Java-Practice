package Tutorial_5_CZ2002;

public class Rectangle extends Polygon{
    public Rectangle(String theName, float theWidth, float theHeight) {
        super(theName, theWidth, theHeight);
        polytype = KindOfPolygon.POLY_RECT;
    }

    @Override
    public float calArea() {
        return height *width;
    }
}
