package Homework_5;

import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i = 0;
        int[] a = new int[n];
        int[] b = new int[m];
        int max = Integer.MIN_VALUE;
        while (i < n){
            a[i] = scanner.nextInt();
            i++;
        }
        i = 0;
        while (i < m){
            b[i] = scanner.nextInt();
            i++;
        }
        if (b[m-1] > a[n-1]){
            max = b[m-1];
        } else {
            max = a[n-1];
        }

        int[] count = new int[max + 1];
        i = 0;
        while (i < n){
            count[a[i]]++;
            i++;
        }
        i = 0;
        while (i < m){
            count[b[i]]++;
            i++;
        }

        //Log AND
        int freeIndex = 0;
        int[] result1 = new int[max + 1];
        i = 0;
        while (i < result1.length){
            if (count[i] >= 2){
                result1[freeIndex] = i;
                freeIndex++;
            }
            i++;
        }

        System.out.println("LOGICAL AND :");
        i = 0;
        while (i < max){
            if (result1[i] != 0){
                System.out.print(result1[i] + " ");
            }
            i++;
        }
        System.out.println();

        //Log OR
        i = 0;
        freeIndex = 0;
        int[] result2 = new int[n + m + 1];
        while (i < count.length){
            if (count[i] >= 1){
                result2[freeIndex] = i;
                freeIndex++;
            }
            i++;
        }

        System.out.println("LOGICAL OR :");
        i = 0;
        while (i < result2.length){
            if (result2[i] != 0){
                System.out.print(result2[i] + " ");
            }
            i++;
        }
        System.out.println();
    }
}
