package Homework_3;

import java.util.Scanner;

public class EncryptTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите k : ");
        int k = scanner.nextInt();

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        int count = 0;
        int i = 0;
        System.out.println("Введите последовательность");
        while (i < n){
            int a = scanner.nextInt();
            a = a + k;
            System.out.println(a % 25);
            i++;
        }
    }
}
