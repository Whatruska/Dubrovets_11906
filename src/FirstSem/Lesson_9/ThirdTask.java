package FirstSem.Lesson_9;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String string = "";
        int action = 0;
        int result = 0;
        int length = input.length();
        for (int i = 0; i < length; i++){
            char ch = input.charAt(i);
            if (ch != ' ' && ch != '+' && ch != '-' && ch != '*'){
                string += ch;
            } else if (ch == '+') {
                action = 0;
            } else if (ch == '-'){
                action = 1;
            } else if (ch == '*'){
                action = 2;
            } else {
                if (action == 0) {
                    result += parseStringToInt(string);
                } else if (action == 1){
                    result -= parseStringToInt(string);
                } else {
                    if (!string.equals("")) {
                        result *= parseStringToInt(string);
                    }
                }
                string = "";
            }
        }
        if (action == 0) {
            result += parseStringToInt(string);
        } else if (action == 1){
            result -= parseStringToInt(string);
        } else {
            result *= parseStringToInt(string);
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
