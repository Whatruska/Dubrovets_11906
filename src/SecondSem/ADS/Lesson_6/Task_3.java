package SecondSem.ADS.Lesson_6;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++){
            arr[i] = i + 1;
        }
        int nFactor = (int) Math.pow(k,2);
        int[][] matrix = new int[nFactor][];
        int matrixInd = 0;
        for (int i = 0; i < nFactor; i++){
            String str = toBinaryStr(i,k);
            int size = 0;
            for (int j = 0; j < str.length(); j++){
                int bit = str.charAt(j) - '0';
                if (bit == 1){
                    size++;
                }
            }
            int[] set = new int[size];
            int s = 0;
            for (int index = 0; index < str.length(); index++){
                if (str.charAt(index) == '1'){
                    set[s] = arr[index];
                    s++;
                }
            }
            matrix[matrixInd] = set;
            matrixInd++;
        }

        for (int i = 0; i < nFactor; i++){
            for (int j = i + 1; j < nFactor - 1; j++){
                int[] el1 = matrix[i];
                int[] el2 = matrix[j];
                if (el2.length < el1.length){
                    int[] temp = el1;
                    matrix[i] = el2;
                    matrix[j] = temp;
                }
            }
        }

        for (int[] ar : matrix){
            System.out.println(arrToStr(ar));
        }
    }

    public static String toBinaryStr(int num, int length){
        StringBuilder builder = new StringBuilder();
        while (num > 0){
            builder.append(num % 2);
            num /= 2;
        }
        for (int i = builder.length(); i < length; i++){
            builder.append(0);
        }
        return builder.reverse().toString();
    }

    public static String arrToStr(int[] arr){
        String str = "{";
        for (int i : arr){
            str += " " + i + " ";
        }
        str += "}";
        return str;
    }

}
