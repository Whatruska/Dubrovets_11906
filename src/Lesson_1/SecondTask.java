package Lesson_1;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        System.out.print("Введите x : ");
        int x = scanner.nextInt();

        int count = 0;
        int result = 0;
        int xInFactor = 1;
        while (count < n/2){
            int a = scanner.nextInt();
            int currResult = a * xInFactor;
            result = result + currResult;
            xInFactor = xInFactor * x;
            count++;
        }

        System.out.println(result);
    }
}
