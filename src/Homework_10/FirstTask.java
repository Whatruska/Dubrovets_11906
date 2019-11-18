package Homework_10;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String string = "";
        boolean isPlus = true;
        int result = 0;
        int length = input.length();
        for (int i = 0; i < length; i++){
            char ch = input.charAt(i);
            if (ch != ' ' && ch != '+' && ch != '-'){
                string += ch;
            } else if (ch == '+') {
                isPlus = true;
            } else if (ch == '-'){
                isPlus = false;
            } else {
                if (isPlus) {
                    result += parseStringToInt(string);
                } else {
                    result -= parseStringToInt(string);
                }
                string = "";
            }
        }
        if (isPlus) {
            result += parseStringToInt(string);
        } else {
            result -= parseStringToInt(string);
        }
        System.out.println(result);
    }


    private static int parseStringToInt(String string){
        if (string.equals("") || string.equals("+") || string.equals("0")){
            return 0;
        }
        int result = 0;
        int length = string.length();
        for (int i = 0; i < length; i++){
            int a = charToInt(string.charAt(i));
            result += a * Math.pow(10, length - i - 1);
        }
        return result;
    }

    private static int charToInt(char ch){
        return (int) ch - 48;
    }
}
