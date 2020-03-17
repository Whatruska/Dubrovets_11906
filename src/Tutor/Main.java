package Tutor;

import java.util.Scanner;

public class Main {
    //N - всего элементов
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][];
        int sum = 0;

        //T(N); N = nl (примерно)
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            sum += l;
            matrix[i] = new int[l];
            for (int j = 0; j < l; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        //M(n) + M(N)
        int[] count = new int[n];
        int[] result = new int[sum];
        int resultFreeIndex = 0;

        int minLink = getMinLink(count, matrix);
        //T(Nn)
        while (minLink != -1){
            result[resultFreeIndex++] = matrix[minLink][count[minLink]];
            count[minLink]++;
            //T(n)
            minLink = getMinLink(count, matrix);
        }
        System.out.println(arrToString(result));

        //T(Nn); M(N)
    }

    //-1, если указатели указатели невалидны; T(n)
    private static int getMinLink(int[] count, int[][] matrix) {
        int result = -1;
        int length = count.length;
        int min = Integer.MAX_VALUE;
        //T(n)
        for (int i = 0; i < length; i++){
            if (isValid(i,count,matrix)){
                if (matrix[i][count[i]] < min){
                    min = matrix[i][count[i]];
                    result = i;
                }
            }
        }
        return result;
    }

    //T(1)
    private static boolean isValid(int index, int[] counts, int[][] matrix){
        int length = matrix[index].length;
        return counts[index] < length;
    }

    private static String arrToString(int[] arr){
        String str = "{";
        for (int i : arr){
            str += " " + i + " ";
        }
        str += "}";
        return str;
    }
}
