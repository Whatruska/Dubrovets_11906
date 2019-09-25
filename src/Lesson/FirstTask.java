package Lesson;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int max = Integer.MIN_VALUE;

        while (n != -1){
            if (n > max){
                max = n;
            }
            n = scanner.nextInt();
        }

        System.out.println(max);
    }
}
