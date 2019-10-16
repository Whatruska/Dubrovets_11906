package Lesson_5;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n){
            arr[i] = scanner.nextInt();
            i++;
        }

        i = 0;
        while (i < n/2){
            int elem1 = arr[i];
            int elem2 = arr[n - i - 1];
            arr[i] = elem2;
            arr[n - i - 1] = elem1;
            i++;
        }

        i = 0;
        while (i < n){
            System.out.print(arr[i] + " ");
            i++;
        }
    }
}
