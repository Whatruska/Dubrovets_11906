package FirstSem.Lesson_11;

import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String pattern = scanner.nextLine();
        System.out.println(findIndex(string, pattern));
    }

    public static boolean isEquals(String string, String pattern){
        boolean result = true;
        for (int i = 0; i < string.length(); i++){
            char ch1 = string.charAt(i);
            char ch2 = pattern.charAt(i);
            if (ch1 != ch2 && ch2 != '?'){
                result = false;
            }
        }

        return result;
    }

    public static int emptySymbols(String pattern){
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if (ch != '?'){
                flag = true;
            }
            if (ch == '?' && !flag){
                result++;
            }
        }
        return result;
    }

    public static int findIndex(String string, String pattern){
        StringBuilder builder = new StringBuilder(string);
        int emptySymbols = emptySymbols(pattern);
        int index = builder.toString().indexOf(pattern.charAt(emptySymbols)) - emptySymbols;
        int inputLength = builder.length();
        int patternLength = pattern.length();
        while (index != - 1){
            if (index + patternLength <= inputLength){
                String subString = builder.substring(index, index + patternLength);
                if (isEquals(subString, pattern)){
                    return index;
                }
            }
            builder.deleteCharAt(0);
            index = string.indexOf(pattern.charAt(0));
        }
        return index;
    }
}
