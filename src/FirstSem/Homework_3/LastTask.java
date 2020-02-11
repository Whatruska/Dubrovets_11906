package FirstSem.Homework_3;

import java.util.Scanner;

public class LastTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n : ");
        int n = scanner.nextInt();

        int k = 0;
        boolean isKeyDefined = false;

        int i = 0;
        System.out.println("Введите последовательность");
        while (i < n){
            char ch = scanner.next().charAt(0);
            if (!isKeyDefined){
                k = (int) ch - 'h';
                isKeyDefined = true;
            }
            int a = (int) ch;
            a = a - k;
            System.out.print((char) a + " ");
            i++;
        }
    }
}
