package FirstSem.Homework_5;

import java.util.Scanner;

public class OptimisedFourthTask {
    public static void main(String[] args) {
        //Ввод
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i = 0;
        int[] a = new int[n];
        int[] b = new int[m];
        int index1 = 0, index2 = 0, freeIndex = 0;
        while (i < n){
            a[i] = scanner.nextInt();
            i++;
        }
        i = 0;
        while (i < m){
            b[i] = scanner.nextInt();
            i++;
        }

        //Log AND
        int min = n < m ? n : m;
        int[] result = new int[min];
        while (index1 < n && index2 < m){
            int elem1 = a[index1];
            int elem2 = b[index2];
            if (elem1 == elem2){
                result[freeIndex] = elem1;
                freeIndex++;
                index1++;
            } else if (elem1 > elem2){
                index2++;
            } else {
                index1++;
            }
        }

        System.out.println("LOGICAL AND: ");
        i = 0;
        while (i < result.length){
            if (result[i] != 0){
                System.out.print(result[i] + " ");
            }
            i++;
        }
        System.out.println();

        //LOGICAL OR
        result = new int[n + m];
        index1 = 0;
        index2 = 0;
        freeIndex = 0;
        while (index1 < n || index2 < m){
            if (index1 < n && index2 < m){
                int elem1 = a[index1];
                int elem2 = b[index2];
                if (elem1 < elem2){
                    result[freeIndex] = elem1;
                    freeIndex++;
                    index1++;
                } else if (elem1 > elem2){
                    result[freeIndex] = elem2;
                    freeIndex++;
                    index2++;
                } else {
                    result[freeIndex] = elem1;
                    freeIndex++;
                    index1++;
                    index2++;
                }
            } else if (index1 < n){
                result[freeIndex] = a[index1];
                freeIndex++;
                index1++;
            } else {
                result[freeIndex] = b[index2];
                freeIndex++;
                index2++;
            }
        }

        System.out.println("LOGICAL OR: ");
        i = 0;
        while (i < result.length){
            if (result[i] != 0){
                System.out.print(result[i] + " ");
            }
            i++;
        }
        System.out.println();

        //Third task
        result = a;
        i = 0;
        while (i < m){
            int j = 0;
            int max = result[n-1];
            int elem = b[i];
            while (j < n && elem <= max){
                if (result[j] == b[i]){
                    result[j] = 0;
                    j = n;
                }
                j++;
            }
            i++;
        }

        i = 0;
        System.out.println("THIRD TASK: ");
        while (i < result.length){
            if (result[i] != 0){
                System.out.print(result[i] + " ");
            }
            i++;
        }
        System.out.println();
    }
}
