package Lesson_7;

import java.util.Scanner;

public class FirstTask {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] a = readArray(n);
        int m = scanner.nextInt();
        int[] b = readArray(m);
        int[] c = formNewArray(b,a);
        writeArray(c);
    }

    private static int[] readArray(int length){
        int[] arr = new int[length];
        int n = arr.length;
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    private static void writeArray(int[] arr){
        for (int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    private static int[] formNewArray(int[] arr1, int[] arr2){
        int a = arr1.length;
        int b = arr2.length;
        int[] result = new int[a + b];
        for (int i = 0; i < result.length; i++){
            if (i < a){
                result[i] = arr1[i];
            } else {
                result[i] = arr2[i - a];
            }
        }
        return result;
    }
}
