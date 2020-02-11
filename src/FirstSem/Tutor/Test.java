package FirstSem.Tutor;

import FirstSem.Lesson_16.Animals.Horse;

import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Array<Horse> horses = new Array<>();
        horses.add(new Horse());
        horses.add(new Horse());
        horses.remove(1);
        Object[] objs = horses.toArray();
        for (Object obj : objs){
            System.out.println(obj);
        }
    }
}
