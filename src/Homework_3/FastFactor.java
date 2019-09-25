package Homework_3;

import java.util.Scanner;

public class FastFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        int count = 0;
        int result = 1;

        while (count < n) {
            if (count == 0){
                count++;
                result = result * x;
            } else {
                count = count * 2;
                result = result * result;
            }
        }

        while (count > n){
            count--;
            result = result / x;
        }

        System.out.println(result);
    }
}
