package FirstSem.Lesson_3;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int i = 0;

        while (i < n){
            int a = scanner.nextInt();
            sum += a;
            i++;
        }

        System.out.println((double) sum/n);
    }
}
