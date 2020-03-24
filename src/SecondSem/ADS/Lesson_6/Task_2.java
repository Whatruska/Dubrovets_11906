package SecondSem.ADS.Lesson_6;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++){
            arr[i] = i + 1;
        }
        int nFactor = (int) Math.pow(2,k);
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
                if (str.charAt(index) - '0' == 1){
                    set[s] = arr[index];
                    s++;
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
