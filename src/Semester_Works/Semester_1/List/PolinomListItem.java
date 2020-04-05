package Semester_Works.Semester_1.List;

import java.util.Objects;

public class PolinomListItem implements Comparable {
    private PolinomItem x;
    private PolinomItem y;
    private PolinomItem z;
    private int coef;
    private PolinomListItem next;

    public PolinomListItem(int coef, int deg1, int deg2, int deg3, PolinomListItem next) {
        this.x = new PolinomItem('x', deg1);
        this.y = new PolinomItem('y', deg2);
        this.z = new PolinomItem('z', deg3);
        this.coef = coef;
        this.next = next;
    }

    public PolinomListItem(int coef, int deg1, int deg2, int deg3) {
        this(coef, deg1, deg2, deg3, null);
    }

    public int getXDegree() {
        return x.getDeg();
    }

    public void setXDegree(int degree) {
        this.x.setDeg(degree);
    }

    public int getYDegree() {
        return y.getDeg();
    }

    public void setYDegree(int degree) {
        this.y.setDeg(degree);
    }

    public int getZDegree() {
        return z.getDeg();
    }

    public void setZDegree(int degree) {
        this.z.setDeg(degree);
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public PolinomListItem getNext() {
        return next;
    }

    public void setNext(PolinomListItem next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return Math.abs(coef) +  printItem(x) +  printItem(y) +  printItem(z);
    }

    private String printItem(PolinomItem item){
        return item.getDeg() != 0 ? " * " + item.toString() : "";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof PolinomListItem){
            PolinomListItem item = (PolinomListItem) o;
            int xDeg = x.getDeg();
            int yDeg = y.getDeg();
            int zDeg = z.getDeg();

            int itemXDeg = item.getXDegree();
            int itemYDeg = item.getYDegree();
            int itemZDeg = item.getZDegree();

            if (xDeg > itemXDeg){
                return 1;
            } else if (xDeg == itemXDeg){
                if (yDeg > itemYDeg){
                    return 1;
                } else if (yDeg == itemYDeg){
                    if (zDeg > itemZDeg){
                        return 1;
                    } else if (zDeg == itemZDeg){
                        return 0;
                    }
                }
            }

            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolinomListItem that = (PolinomListItem) o;
        return coef == that.coef &&
                Objects.equals(x, that.x) &&
                Objects.equals(y, that.y) &&
                Objects.equals(z, that.z);
    }

    public PolinomListItem copy(){
        return new PolinomListItem(coef, x.getDeg(), y.getDeg(), z.getDeg());
    }
}
