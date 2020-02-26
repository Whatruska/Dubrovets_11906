package SecondSem.Informatics.Lesson_4;

public class Girl extends Student {
    public Girl(int height) {
        super(height);
    }

    @Override
    public void doExcercise() {
        setExcercises(getExcercises() + 20);
    }

    @Override
    public String toString() {
        return "Girl \n" + super.toString();
    }
}
