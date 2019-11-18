package Homework_9;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int x = 0, y = 0;
        boolean flag = false;
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (isNumber(ch)){
                if (!flag){
                    x = charToInt(ch);
                    flag = true;
                } else {
                    y = charToInt(ch);
                }
            }
        }
        System.out.println(x + y);
    }

    private static int charToInt(char ch){
        return ch - 48;
    }

    private static boolean isNumber(char ch){
        int intCh = charToInt(ch);
        return intCh >= charToInt('0') && intCh <= charToInt('9') ;
    }
}
