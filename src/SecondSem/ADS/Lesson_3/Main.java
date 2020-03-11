package SecondSem.ADS.Lesson_3;

import SecondSem.ADS.Lesson_3.Tree.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(15, "Petya");
        map.put(10, "Anya");
        map.put(8, "Sanya");
        map.put(20, "Sanya");
        map.put(18, "Misha");

        map.remove(10);

    }
}
