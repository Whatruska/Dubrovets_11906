package Homework_5;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int count = 0;
        while (i < n){
            int a = scanner.nextInt();
            if (a < 0){
                count++;
            }
            i++;
        }

        if (count > 0){
            System.out.println("Есть отрицательные");
        } else {
            System.out.println("Нет отрицательных");
        }
    }
}
