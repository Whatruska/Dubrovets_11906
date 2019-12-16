package Lesson_13;

public class Marks {
    private int mathMark;
    private int infoMark;
    private int algMark;

    public int getMathMark() {
        return mathMark;
    }

    public void setMathMark(int mathMark) {
        this.mathMark = mathMark;
    }

    public int getInfoMark() {
        return infoMark;
    }

    public void setInfoMark(int infoMark) {
        this.infoMark = infoMark;
    }

    public int getAlgMark() {
        return algMark;
    }

    public void setAlgMark(int algMark) {
        this.algMark = algMark;
    }

    public Marks(int mathMark, int infoMark, int algMark) {
        this.mathMark = mathMark;
        this.infoMark = infoMark;
        this.algMark = algMark;
    }

    @Override
    public String toString() {
        return "Math - " + (getMathMark() > 0 ? getMathMark() : "?") + "\nAlgem - " + (getAlgMark() > 0 ? getAlgMark() : "?") + "\nInfo - " + (getInfoMark() > 0 ? getInfoMark() : "?");
    }
}
