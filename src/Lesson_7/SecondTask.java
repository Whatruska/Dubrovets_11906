package Lesson_7;

import java.util.Scanner;

public class SecondTask {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] a = readArray(n);
        int m = scanner.nextInt();
        int[] b = readArray(m);

        for (int elem : a){
            if (contain(elem, b)){
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }

    }

    private static boolean contain(int elem, int[] arr){
        for (int i : arr){
            if (i == elem){
                return true;
            }
        }
        return false;
    }

    private static int[] readArray(int length){
        int[] arr = new int[length];
        int n = arr.length;
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
