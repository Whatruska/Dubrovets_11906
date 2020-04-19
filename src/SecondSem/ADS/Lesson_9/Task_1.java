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

        f(n, arr, cache);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) ans = Math.max(ans, cache[i]);
        System.out.println(ans);
    }

    public static int f(int e, int[] arr,int[] save) {
        if (e<0) {
            return 0;
        } else {
            if (save[e] ==0) {
                int max = 0;
                for (int i = 0; i < e; i++){
                    if (arr[i]> arr[e]){
                        max = Math.max(max, f(i,arr,save));
                    }
                }
                save[e] = max+1;
            }
        }
        return save[e];
    }
}

