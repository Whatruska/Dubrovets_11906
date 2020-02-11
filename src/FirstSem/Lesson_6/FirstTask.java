package FirstSem.Lesson_6;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x : ");
        float x = scanner.nextFloat();

        System.out.print("Введите y : ");
        float y = scanner.nextFloat();

        boolean bool1 = y * y <= 1 - (x * x);
        boolean bool2 = y >= 0 & x <= 0;
        boolean bool3 = y <= 0 & x >= 0;

        if (bool1 & (bool2 || bool3)){
            System.out.println("(" + x + " ; " + y + ") входит в область");
        } else {
            System.out.println("(" + x + " ; " + y + ") НЕ входит в область");
        }

    }
}
