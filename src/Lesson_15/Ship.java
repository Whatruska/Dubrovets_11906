package Lesson_15;

public abstract class Ship {
    abstract void move(int x, int y);
    void shoot(Ship ship){
        Point center = ship.getCenterOfMass();
        double length = Math.sqrt(Math.pow(center.getX() - centerOfMass.getX(), 2) + Math.pow(center.getY() - centerOfMass.getY(), 2));
        double power = 100 / length;
        double hp = ship.getHp();
        double hpResult = hp - power;
        if (hpResult > 0){
            ship.setHp(hpResult);
        } else {
            ship.setHp(0);
        }
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    Point getCenterOfMass(){
        return centerOfMass;
    }

    protected Point centerOfMass;
    protected double hp = 100;

    @Override
    public String toString() {
        return hp + "";
    }
}
