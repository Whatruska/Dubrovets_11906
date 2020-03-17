package SecondSem.ADS.Lesson_4;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        String s = x + "";
        int first = x / (int) Math.pow(10, s.length() - 1);
        int last = x % 10;
        String str = "";
        int i = 0;
        while (i < n && arr[i] != first){
            i++;
        }
        int j = i;
        while (j < n && arr[j] != last){
            j++;
        }

        for (int k = i; k <= j; k++){
            str += arr[k];
        }
        Integer res = Integer.parseInt(str);
        if (res == x){
            System.out.println(i + " " + j);
        } else {
            System.out.println("Такого вхождения нету");
        }
    }
}
