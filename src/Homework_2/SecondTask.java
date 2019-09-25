package Homework_2;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите p : ");
        int p = scanner.nextInt();

        int count = 2;
        boolean isPrime = true;
        while (count < p){
            if (p % count == 0){
                isPrime = false;
                break;
            }
            count++;
        }

        if (isPrime){
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }
    }
}
