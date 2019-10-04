package Lesson_2;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x : ");
        double x = scanner.nextDouble();

        System.out.print("Введите y : ");
        double y = scanner.nextDouble();

        boolean bool2 = y >= 0;
        boolean bool3 = y <= x + 1;
        boolean bool4 =  y <= -x + 1;

        if (bool2 && bool3 && bool4){
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
