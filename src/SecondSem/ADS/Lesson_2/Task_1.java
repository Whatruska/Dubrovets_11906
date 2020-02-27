package SecondSem.ADS.Lesson_2;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[][] matrix = new int[k][];
        for (int i = 0; i < k; i++){
            int l = scanner.nextInt();
            matrix[i] = new int[l];
            for (int j = 0; j < l; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[] res = new int[0];
        for (int i = 0; i < matrix.length; i++){
            res = merge(res, matrix[i]);
        }

        for (int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length){
            res[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length){
            res[k] = arr2[j];
            j++;
            k++;
        }
        return res;
    }
}
