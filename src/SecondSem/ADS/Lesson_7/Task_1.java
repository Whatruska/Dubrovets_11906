package SecondSem.ADS.Lesson_7;

import java.util.HashSet;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++){
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++){
                set.add(scanner.next());
            }
        }
        System.out.println(set.size());
    }
}
