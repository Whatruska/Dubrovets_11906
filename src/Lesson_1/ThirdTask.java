package Lesson_1;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while (i < n){
            int a = scanner.nextInt();
            a++;
            System.out.println(a % 25);
            i++;
        }
    }
}
