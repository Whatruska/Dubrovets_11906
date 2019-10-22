package Lesson_6;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x : ");
        float x = scanner.nextFloat();

        System.out.print("Введите y : ");
        float y = scanner.nextFloat();


        boolean bool1 = y >= -1 && y <= 1 && x >= -1 && x <= 1;
        boolean bool2 = (y * y <= 1 - (x * x)) && (x <= 0 && y >= 0);
        boolean bool3 = y <= 0 & x >= 0;
        boolean bool4 = (y >= -x + 1) && (x >= 0 && y >= 0);
        boolean bool5 = (y >= -x - 1) && (x <= 0 && y <= 0);

        if (bool1 & (bool2 || bool3 || bool4 || bool5)){
            System.out.println("(" + x + " ; " + y + ") входит в область");
        } else {
            System.out.println("(" + x + " ; " + y + ") НЕ входит в область");
        }
    }
}
