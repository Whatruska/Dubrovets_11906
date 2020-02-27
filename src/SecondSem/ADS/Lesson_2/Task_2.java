package SecondSem.ADS.Lesson_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Scanner scanner = new Scanner(new File(PathHelper.getPathTo("input_2.txt")));
        int n = scanner.nextInt();
        Set<Long> numbers = new Set<>();
        for (int i = 0; i < n; i++){
            numbers.add(scanner.nextLong());
        }
        System.out.println(numbers.size());
        numbers.printSet();
    }

}
