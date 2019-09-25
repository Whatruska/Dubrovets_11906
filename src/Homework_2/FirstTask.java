package Homework_2;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x : ");
        int x = scanner.nextInt();

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        int count = 0;
        int result = 1;
        while (count < n){
            result = result * x;
            count++;
        }

        System.out.println("Х в степени N = " + result);
    }
}
