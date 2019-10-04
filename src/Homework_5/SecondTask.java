package Homework_5;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while (i < n){
            int a = scanner.nextInt();
            if (a != 0){
                System.out.print(a + " ");
            }
            i++;
        }
    }
}
