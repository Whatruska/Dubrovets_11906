package FirstSem.ShapeCompare;

abstract public class Shape {
    protected Point[] points;
    protected Line[] lines;

    protected void initShape(){
        points = initPoints();
        lines = initLines();
    }

    public Line[] getLines() {
        return lines;
    }

    protected Line[] initLines(){
        Line[] result = new Line[points.length > 2 ? points.length : points.length - 1];
        for (int i = 0; i < points.length; i++){
            if (i == points.length - 1){
                if (points.length > 2) {
                    result[i] = new Line(points[0], points[i]);
                }
                continue;
            }
            result[i] = new Line(points[i], points[i + 1]);
        }
        return result;
    }

    abstract Point[] initPoints();

    public boolean isIntersects(Shape shape){
        Line[] shapeLines = shape.getLines();
        for (int i = 0; i < lines.length; i++){
            Line line = lines[i];
            for (int j = 0; j < shapeLines.length; j++){
                Line secondLine = shapeLines[i];
                if (line.isIntersects(secondLine)){
                    return true;
                }
            }
        }
        return false;
    }
}
