package SecondSem.ADS.Lesson_9;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cache = new int[n + 1];
        System.out.println(f(n, cache));
    }

    public static int f(int i, int[] cache){
        if (i < 0){
            return 0;
        } else if (i == 0){
            return 1;
        } else if (i < 3){
            return 1;
        }
        if (cache[i] == 0){
            int result = f(i - 1, cache) + f(i - 3, cache) + f(i - 5, cache);
            cache[i] = result;
        }
        return cache[i];
    }
}
