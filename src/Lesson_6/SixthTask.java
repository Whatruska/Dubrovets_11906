package Lesson_6;

import java.util.Scanner;

public class SixthTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Ввод
        int n = scanner.nextInt();
        int i = 0, j = 0;
        int[][] arr = new int[n][n];
        while (i < n){
            j = 0;
            while (j < n){
                arr[i][j] = scanner.nextInt();
                j++;
            }
            i++;
        }

        //Обработка
        i = 0;
        j = 0;
        while (i < n){
            j = i;
            while (j < n){
                int c = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = c;
                j++;
            }
            i++;
        }

        //Ввывод
        i = 0;
        while (i < n){
            j = 0;
            while (j < n){
                System.out.print(arr[i][j] + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
