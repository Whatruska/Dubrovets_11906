package Homework_6;

import java.util.Scanner;

public class BubleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0, j = 0;
        while (i < n){
            arr[i] = scanner.nextInt();
            i++;
        }

        i = 0;
        while (i < n - 1){
            j = i + 1;
            while (j < n){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
            i++;
        }

        i = 0;
        while (i < n){
            System.out.print(arr[i] + " ");
            i++;
        }
    }
}
