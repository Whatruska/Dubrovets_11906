package SecondSem.ADS.Lesson_9;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cache = new int[n + 1];
        System.out.println(f(n, cache));
    }

    public static int f(int i, int[] cache){
        if (i < 1){
            return 0;
        } else if (i == 2) {
            return 1;
        }
        if (cache[i] == 0){
            //f(i) = f(i - 1) * 2 + 1;
            int result = f(i - 1, cache) * 2 + 1;
            cache[i] = result;
        }
        return cache[i];
    }
}
