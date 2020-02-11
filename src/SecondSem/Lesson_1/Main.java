package SecondSem.Lesson_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String string = scanner.nextLine();
        System.out.println(Calculator.calculate(string));
    }
}
