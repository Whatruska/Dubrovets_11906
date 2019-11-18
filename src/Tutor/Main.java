package Tutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int m = 0, sum = 0, a = 0;
        for (int i = 0; i < s.length(); i++){
            a = s.charAt(i);
            if ((a != '+') || (a != ' ')) {
                m = charToInt((char)a);
                System.out.print(m);
                sum = sum + m;
            }
        }
        System.out.print(sum);
    }

    public static int charToInt(char a) {
        return a - 48;
    }
}
