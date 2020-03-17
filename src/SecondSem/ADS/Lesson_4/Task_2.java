package SecondSem.ADS.Lesson_4;

import java.util.Arrays;
import java.util.Scanner;


public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int nFactor = (int) Math.pow(n,2);
        for (int i = 0; i < nFactor; i++){
            String str = toBinaryStr(i,n);
            int size = 0;
            for (int j = 0; j < str.length(); j++){
                int bit = str.charAt(j) - '0';
                if (bit == 1){
                    size++;
                }
            }
            int[] set = new int[size];
            int k = 0;
            for (int index = 0; index < n; index++){
                if (str.charAt(index) - '0' == 1){
                    set[k] = arr[index];
                    k++;
                }
            }
            System.out.println(arrToStr(set));
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
