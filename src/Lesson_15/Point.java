package Lesson_15;

import java.util.Random;

public class Point {
    public static final int RANDOM_BOUNDS = 100;

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint(int x, int y){
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static Point getRandomPoint(){
        Random random = new Random();
        return new Point(random.nextInt(RANDOM_BOUNDS), random.nextInt(RANDOM_BOUNDS));
    }
}
