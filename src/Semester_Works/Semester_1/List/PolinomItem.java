package Semester_Works.Semester_1.List;

public class PolinomItem {
    private char var;
    private int deg;

    public PolinomItem(char var, int deg) {
        this.var = var;
        this.deg = deg;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolinomItem that = (PolinomItem) o;
        return var == that.var &&
                deg == that.deg;
    }

    @Override
    public String toString() {
        return  var + "^" + deg;
    }
}
