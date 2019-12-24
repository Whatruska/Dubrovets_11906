package Lesson_16.Animals;

import Lesson_16.Interfaces.Animal;
import Lesson_16.Interfaces.Milkable;
import Lesson_16.Interfaces.Woolable;

public class Goat extends Animal implements Milkable, Woolable {
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
    public int getWool() {
        return 0;
    }
}
