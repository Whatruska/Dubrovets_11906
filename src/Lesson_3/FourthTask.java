package Lesson_3;

import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int count = 0;
        int i = 0;

        while (i < n){
            int a = scanner.nextInt();
            if (a == x){
                count++;
            }
            i++;
        }

        if (count > 0){
            System.out.println("X (" + x + ") присутствует в последовательности");
        } else {
            System.out.println("X (" + x + ") отсутствует в последовательности");
        }
    }
}
