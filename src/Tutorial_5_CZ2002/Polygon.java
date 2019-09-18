package Tutorial_5_CZ2002;

abstract public class Polygon {
    public enum KindOfPolygon{POLY_PlAIN, POLY_RECT,POLY_TRIANG};
    protected String name;
    protected  float width, height;
    protected  KindOfPolygon polytype;
    public Polygon(String theName, float theWidth, float theHeight){
        name = theName;
        width = theWidth;
        height = theHeight;
        polytype = KindOfPolygon.POLY_PlAIN;
    }
    public KindOfPolygon getPolytype(){
        return polytype;
    }
    public void setPolytype(KindOfPolygon value){
        polytype = value;
    }

    public String getName() {
        return name;
    }
    abstract public float calArea();
    public void printWidthHeight(){
        System.out.println("Width= " + width + "Height = " + height);
    }
}
