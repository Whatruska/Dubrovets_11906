package FirstSem.Lesson_7;

import java.util.Scanner;

public class TestTask {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = readMatrix(n,m);
        writeMatrix(arr);
    }

    private static int[][] readMatrix(int n, int m){
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    private static void writeMatrix(int[][] matrix){
        for (int[] arr : matrix){
            for (int elem : arr){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
