package ShapeCompare;

public class Main {
    public static void main(String[] args) {
        NShape shape = new NShape(
                new Point(5,10),
                new Point(1,2)
        );
        System.out.println(shape.isIntersects(new NShape(
                new Point(4,3),
                new Point(14,7)
        )));
    }
}
