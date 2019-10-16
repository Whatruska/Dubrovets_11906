package Lesson_4;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        int i = 0, j = 0;
        while (i < n){
            j = 0;
            while (j < n){
                arr[i][j] = scanner.nextInt();
                j++;
            }
            i++;
        }
        int length = n;
        int currX = 0, currY = 0;
        while (length > 0){
            i = 0;
            while (i < length){
                System.out.print(arr[currY][currX] + " ");
                i++;
                if (i != length){
                    currX++;
                }
            }
            i = 0;
            while (i < length){
                if (i != 0){
                    System.out.print(arr[currY][currX] + " ");
                }
                i++;
                if (i != length){
                    currY++;
                }
            }
            i = 0;
            while (i < length){
                if (i != 0){
                    System.out.print(arr[currY][currX] + " ");
                }
                i++;
                if (i != length){
                    currX--;
                }
            }
            i = 0;
            while (i < length - 1){
                if (i != 0){
                    System.out.print(arr[currY][currX] + " ");
                }
                i++;
                if (i != length - 1){
                    currY--;
                }
            }
            currX++;
            length -= 2;
        }
    }
}
