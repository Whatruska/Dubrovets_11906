package Tutor;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Cow cow = new Cow(32);
        Horse horse = new Horse(32);
        Animal[] animals = new Animal[]{cow, horse};
        Arrays.sort(animals, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (o1.mass > o2.mass){
                    return 1;
                } else if (o1.mass < o2.mass){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
