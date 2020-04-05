package SecondSem.ADS.Lesson_9;

import Tutor.Main;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        int[] cache = new int[n + 1];
        for (int i = 1; i < n + 1; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(f(n, arr, cache));
    }

    public static int f(int i, int[] arr, int[] cache){
        if (i <= 0){
            return 0;
        } else if (i == 1){
            cache[i] = 1;
            return 1;
        } else {
            if (cache[i] == 0){
                int ind = i;
                while (ind > 0 && arr[ind] >= arr[i]){
                    ind--;
                }
                if (ind <= 0){
                    cache[i] = f(i - 1, arr, cache);
                } else {
                    cache[i] = f(ind, arr, cache) + 1;
                    cache[i] = Math.max(cache[i], f(i - 1, arr, cache));
                }
            }
            return cache[i];
        }
    }
}
