package FirstSem.Lesson_16.Animals;

import FirstSem.Lesson_16.Interfaces.Animal;
import FirstSem.Lesson_16.Interfaces.Milkable;
import FirstSem.Lesson_16.Interfaces.Moveable;

public class Cow extends Animal implements Milkable, Moveable {
    @Override
    public void eat(int weight) {

    }

    @Override
    public int getMeat() {
        return 0;
    }

    @Override
    public int getMilk() {
        return 0;
    }

    @Override
    public void move(int weight) {

    }
}
