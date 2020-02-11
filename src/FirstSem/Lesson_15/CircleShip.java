package FirstSem.Lesson_15;

import java.util.Random;

public class CircleShip extends Ship {
    private Point coordinates;
    private double radius;

    public CircleShip(Point coordinates, double radius) {
        this.coordinates = coordinates;
        this.radius = radius;
        centerOfMass = new Point(coordinates.getX(), coordinates.getY());
    }

    public CircleShip() {
        this(Point.getRandomPoint(), new Random().nextInt(Point.RANDOM_BOUNDS));
    }

    @Override
    void move(int x, int y) {
        coordinates.movePoint(x,y);
    }
}
