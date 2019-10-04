package Lesson_3;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        int i = 0;
        if (n != m){
            System.out.println("Не равны");
        } else {
            int[] a = new int[n];
            while (i < n){
                a[i] = scanner.nextInt();
                i++;
            }
            i = 0;
            while (i < m){
                int b = scanner.nextInt();
                if(b != a[i]){
                    count++;
                }
                i++;
            }
            if (count > 0){
                System.out.println("Не равны");
            } else {
                System.out.println("Равны");
            }
        }
    }
}
