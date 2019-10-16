package Tutor;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 1;
        int b = 1;
        int fib = 0;
        int n = scanner.nextInt();
        int i = 1;
        while (i <= n){
            if (i < 3) {
                System.out.print(1 + " ");
            } else {
                fib = a + b;
                a = b;
                b = fib;
                System.out.print(fib + " ");
            }
            i++;
        }
    }
}
