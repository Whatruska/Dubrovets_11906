package SecondSem.ADS.Lesson_1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = scanner.nextLine();
        BigNum num = new BigNum(str);
        num.sumInt(str2);
        System.out.println(num);
    }
}
