package SecondSem.Informatics.Lesson_4;

public class Boy extends Student {
    public Boy(int height) {
        super(height);
    }

    @Override
    public void doExcercise() {
        setExcercises(getExcercises() + 20);
    }

    @Override
    public String toString() {
        return "Boy \n" + super.toString();
    }
}
