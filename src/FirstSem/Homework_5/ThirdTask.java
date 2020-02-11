package FirstSem.Homework_5;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int i = 0;
        boolean isFinish = false;
        boolean isFound = false;

        while (i < n){
            if (!isFinish){
                int a = scanner.nextInt();
                if (a > x || a == x){
                    isFinish = true;
                    if (a == x){
                        isFound = true;
                    }
                }
            } else {
                i = n;
            }
        }

        if (isFound){
            System.out.println("X присутствует в последовательности");
        } else {
            System.out.println("X отсутствует");
        }
    }
}
