package SecondSem.ADS.Lesson_6;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[k];
        rec(0, arr, n);
    }

    public static void rec(int x, int[] arr, int n) {
        if (x == arr.length){
            System.out.println(arrToStr(arr));
        } else {
            for (int i = 1; i <= n; i++){
                arr[x] = i;
                rec(x + 1, arr, n);
            }
        }
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
