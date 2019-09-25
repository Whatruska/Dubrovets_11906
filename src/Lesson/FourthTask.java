package Lesson;

import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while (i < n){
            int a = scanner.nextInt();
            a--;
            if (a == -1){
                a = a + 25 + 1;
            }
            System.out.println(a);
            i++;
        }
    }
}
