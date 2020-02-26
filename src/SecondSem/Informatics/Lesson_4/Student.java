package SecondSem.Informatics.Lesson_4;

abstract public class Student {
    private int height;
    private int excercises;

    public Student(int height) {
        this.height = height;
        excercises = 0;
    }

    public int getHeight() {
        return height;
    }

    public int getExcercises() {
        return excercises;
    }

    public void setExcercises(int excercises) {
        this.excercises = excercises;
    }

    abstract public void doExcercise();
}
