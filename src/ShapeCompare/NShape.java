package ShapeCompare;

public class NShape extends Shape {
    private Point[] points;
    public NShape(Point... points) {
        this.points = points;
        initShape();
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    Point[] initPoints() {
        return points;
    }
}
