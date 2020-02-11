package FirstSem.Lesson_15;

import java.util.Random;

public class SquareShip extends Ship {
    private Point coordinates;
    private double width;
    private double heigth;

    public SquareShip(Point coordinates, double width, double heigth) {
        this.coordinates = coordinates;
        this.width = width;
        this.heigth = heigth;
        centerOfMass = new Point(coordinates.getX() + (this.width / 2), coordinates.getY() + (this.heigth / 2));
    }

    public SquareShip(){
        this(Point.getRandomPoint(), new Random().nextInt(Point.RANDOM_BOUNDS), new Random().nextInt(Point.RANDOM_BOUNDS));
    }

    @Override
    void move(int x, int y) {
        coordinates.movePoint(x,y);
    }
}
