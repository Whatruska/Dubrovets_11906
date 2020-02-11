package FirstSem.Lesson_15;

public class TriangleShip extends Ship {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public TriangleShip() {
        this(Point.getRandomPoint(), Point.getRandomPoint(), Point.getRandomPoint());
    }

    public TriangleShip(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        centerOfMass = countCenterOfMass();
    }

    private Point countCenterOfMass(){
        double averageX = (firstPoint.getX() + secondPoint.getX() + thirdPoint.getX()) / 3;
        double averageY = (firstPoint.getY() + secondPoint.getY() + thirdPoint.getY()) / 3;
        return new Point(averageX, averageY);
    }

    @Override
    void move(int x, int y) {
        firstPoint.movePoint(x,y);
        secondPoint.movePoint(x,y);
        thirdPoint.movePoint(x,y);
    }
}
