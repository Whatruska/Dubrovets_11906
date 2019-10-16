package Lesson_4;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i = 0;
        int force = 0;
        while (i < n * m){
            force += scanner.nextInt();
            i++;
        }
        if (force > 0){
            System.out.println("WIN");
        } else if (force == 0){
            System.out.println("DRAW");
        } else {
            System.out.println("LOSE");
        }
    }
}
