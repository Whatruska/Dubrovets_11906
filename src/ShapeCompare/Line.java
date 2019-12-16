package ShapeCompare;

public class Line {
    private Point point1;
    private Point point2;
    private double k;
    private double b;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        k = countK();
        b = countB();
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public double getK() {
        return k;
    }

    public double getB() {
        return b;
    }

    private double countK(){
        double deltaY = point2.getY() - point1.getY();
        double deltaX = point2.getX() - point1.getX();
        if (deltaX != 0){
            return deltaY/deltaX;
        }
        //Если прямая вида y = a
        return 0;
    }

    private double countB(){
        double deltaX = point2.getX() - point1.getX();
        //Если прямая вида x = a
        if (deltaX == 0){
            return 0;
        }
        return point1.getY() - k * point1.getX();
    }

    public boolean isIntersects(Line line){
        double k2 = line.getK();
        double b2 = line.getB();
        double deltaB = b2 - b;
        double deltaK = k - k2;

        //Параллельные и лежащие на одной прямой
        if (deltaK == 0){
            if (b == b2){
                if (point1.getX() - line.getPoint1().getX() == 0) {
                    return checkLinearY(line);
                }  else if (point1.getY() - line.getPoint1().getY() == 0){
                    return checkLinearX(line);
                }
            } else {
                return false;
            }
        }

        double interX = deltaB/deltaK;
        if (this.isInXRange(interX) && line.isInXRange(interX)){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkLinearX(Line line){
        double minX = Math.min(point1.getX(), point2.getX());
        double minX2 = Math.min(line.getPoint1().getX(), line.getPoint2().getX());
        return this.isInXRange(minX2) || line.isInXRange(minX);
    }

    private boolean checkLinearY(Line line){
        double minY = Math.min(point1.getY(), point2.getY());
        double minY2 = Math.min(line.getPoint1().getY(), line.getPoint2().getY());
        return this.isInYRange(minY2) || line.isInYRange(minY);
    }

    private boolean isInXRange(double x){
        double minX = Math.min(point1.getX(), point2.getX());
        double maxX = Math.max(point1.getX(), point2.getX());
        return x >= minX && x <= maxX;
    }

    private boolean isInYRange(double y){
        double minY = Math.min(point1.getY(), point2.getY());
        double maxY = Math.max(point1.getY(), point2.getY());
        return y >= minY && y <= maxY;
    }
}
