package Lesson_5;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        //Ввод
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        int i = 0;
        int j = 0;
        while (i < n){
            j = 0;
            while (j < n){
                arr[i][j] = scanner.nextInt();
                j++;
            }
            i++;
        }

        //Обработка
//        int d = n/2;
//        int center = n/2;
//        i = 0;
//        while (i < n){
//            int elem1 = arr[i][center - d];
//            int elem2 = arr[i][center + d];
//
//            arr[i][center - d] = elem2;
//            arr[i][center + d] = elem1;
//
//            d--;
//            i++;
//        }
        //Обработка вариант 2
        i = 0;
        while (i < n){
            int c = arr[i][i];
            arr[i][i] = arr[i][n-i-1];
            arr[i][n-i-1] = c;
            i++;
        }

        //Вывод
        i = 0;
        while (i < n){
            j = 0;
            while (j < n){
                System.out.print(arr[i][j] + " ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
