package Homework_3;

import java.util.Scanner;

public class DecryptTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        System.out.print("Введите k : ");
        int k = scanner.nextInt();

        int i = 0;
        System.out.println("Введите последовательность");
        while (i < n){
            int a = scanner.nextInt();
            a = a + 25;
            a = a - k;
            a++;
            System.out.println(a % 26);
            i++;
        }
    }
}
