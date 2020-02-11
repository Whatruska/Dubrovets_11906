package FirstSem.Homework_2;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x : ");
        int x = scanner.nextInt();

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        int p = 1;

        while (n > 1){
            if (n % 2 == 0){
                n /= 2;
                x *= x;
            } else {
                p *= x;
                n--;
            }
        }

        System.out.println("Х в степени N = " + p * x);
    }
}
