package FirstSem.Homework_5;

import java.util.Scanner;

public class FourthTask_SecondPart {
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

        boolean[] count = new boolean[max + 1];
        i = 0;
        while (i < n){
            count[a[i]] = true;
            i++;
        }
        i = 0;
        while (i < m){
            count[b[i]] = false;
            i++;
        }

        System.out.println("LOGICAL XOR");
        i = 0;
        while (i < count.length){
            if (count[i]){
                System.out.print(i + " ");
            }
            i++;
        }
    }
}
