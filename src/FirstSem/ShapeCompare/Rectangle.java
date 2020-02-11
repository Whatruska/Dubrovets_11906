package FirstSem.ShapeCompare;

public class Rectangle extends Shape {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        initShape();
    }

    @Override
    Point[] initPoints() {
        return new Point[]{point1,point2,point3,point4};
    }
}
