package SecondSem.Informatics.Lesson_6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Class c = TestClass.class;
        ArrayList<Object> list = (ArrayList<Object>) Framework.getInstances(TestClass.class);
        for (Object o : list){
            System.out.println(o);
        }
        System.out.println();
        Framework.getByField(TestClass.class, c.getDeclaredField("gender"), "male").forEach(System.out::println);
    }
}
