package FirstSem.Tutor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class c = Array.class;
        Constructor[] constructors = c.getConstructors();
        Field[] fields = c.getDeclaredFields();
        Field freeIndex = fields[1];
        freeIndex.setAccessible(true);
        System.out.println(freeIndex);
        System.out.println(freeIndex.getModifiers());
    }
}
