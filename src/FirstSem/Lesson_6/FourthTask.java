package FirstSem.Lesson_6;

import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = 0, c = 0;
        int i = 0;
        while (a != -1){
            if (i >= 2){
                System.out.print(a + b + c + " ");
            }
            c = b;
            b = a;
            i++;
            a = scanner.nextInt();
        }
    }
}
