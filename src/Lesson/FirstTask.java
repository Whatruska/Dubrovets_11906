package Lesson;

import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int num = 0;
        int sum = 0;

        while (a != -1){
            sum = sum + a;
            num++;
            a = scanner.nextInt();
        }

        System.out.println(sum / num);
    }
}
