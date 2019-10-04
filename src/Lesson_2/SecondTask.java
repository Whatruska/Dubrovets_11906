package Lesson_2;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x : ");
        double x = scanner.nextDouble();

        System.out.print("Введите y : ");
        double y = scanner.nextDouble();

        boolean bool1 = (x > 1 || x < -1);
        boolean bool2 = (y > 1 || y < -1);
        boolean bool3 = (y < x + 1 && y > 0 && x < 0);
        boolean bool4 = (y > x - 1 && y < 0 && x > 0);

        if (bool1 || bool2 || bool3 || bool4){
            System.out.println("Нет");
        } else {
            System.out.println("Да");
        }
    }
}
