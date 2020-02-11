package FirstSem.Lesson_6;

import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int maxSum = Integer.MIN_VALUE;
        int maxInd = 0;
        int i = 0, j = 0;
        int[][] arr = new int[n][m];
        while (i < n){
            j = 0;
            while (j < m){
                arr[i][j] = scanner.nextInt();
                j++;
            }
            i++;
        }

        i = 0;
        while (i < m){
            j = 0;
            int sum = 0;
            while (j < n){
                sum += arr[j][i];
                j++;
            }
            if (sum > maxSum){
                maxSum = sum;
                maxInd = i;
            }
            i++;
        }

        System.out.println(maxInd);
    }
}
