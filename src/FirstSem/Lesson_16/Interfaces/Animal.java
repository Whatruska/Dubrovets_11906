package FirstSem.Lesson_16.Interfaces;

public abstract class Animal implements Eatable, Meatable {
    protected int mass;
    public int getMass(){
        return mass;
    }
}
