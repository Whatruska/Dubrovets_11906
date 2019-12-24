package Lesson_16;

import Lesson_16.Animals.Horse;

public class Loader {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.addNewAnimal(new Horse());
        farm.feedAll(10);
    }
}
