package Tutorial_3_CZ2002;

public class Point {
    public int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "[ " + x + "," + y + " ]";
    }
    public void setPoint(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
