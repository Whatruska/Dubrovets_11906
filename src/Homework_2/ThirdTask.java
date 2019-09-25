package Homework_2;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int y = 0;

        System.out.print("Введите x : ");
        int x = scanner.nextInt();

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        int result = 0;
        int i = 1;
        while (i <= n){

            int count = 0;
            int upResult = 1;
            int twoInFactor = 1;

            while (count < i + 3){
                upResult = upResult * x;
                if (count < i){
                    twoInFactor = twoInFactor * 2;
                }
                count++;
            }

            int a = upResult / twoInFactor;
            int b = i + 1;
            a = a / b;
            result = result + a;

            i++;
        }

        System.out.println("Результат : " + result);
    }
}
