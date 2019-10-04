package Lesson_2;

import java.util.Scanner;

public class SecondTask_2 {
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

        boolean isCorrect = false;

        if (!bool1 || bool2 || bool3 || bool4){
            if (!bool2){
                if (!bool3){
                    if (!bool4){
                        System.out.println("Да");
                        isCorrect = true;
                    }
                }
            }
        }
        if (!isCorrect){
            System.out.println("Нет");
        }
    }
}
