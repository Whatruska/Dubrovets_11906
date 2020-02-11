package FirstSem.Lesson_9;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = new String[countSpaces(input) + 1];
        String string = "";
        int counter = 0;
        int length = input.length();
        for (int i = 0; i < length; i++){
            char ch = input.charAt(i);
            if (ch != ' '){
                string += ch;
            } else {
                words[counter] = string;
                counter++;
                string = "";
            }
        }
        words[words.length - 1] = string;

        words[1] = "";
        for (int i = 0; i < words.length; i++){
            System.out.print(words[i]);
            if (!words[i].equals("")){
                System.out.print(" ");
            }
        }
    }

    private static int countSpaces(String string){
        int result = 0;
        int l = string.length();
        for (int i = 0; i < l; i++){
            if (string.charAt(i) == ' '){
                result++;
            }
        }
        return result;
    }
}
