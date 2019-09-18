package Tutorial_5_CZ2002;

public class Triangle extends Polygon {
    public Triangle(String theName, float theWidth, float theHeight) {
        super(theName, theWidth, theHeight);
        polytype = KindOfPolygon.POLY_TRIANG;
    }

    @Override
    public float calArea() {
        return width * height / 2 ;
    }


}