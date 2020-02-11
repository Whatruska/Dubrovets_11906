package FirstSem.Homework_9;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();
        int i = 0;
        int count = 0;
        boolean flag = false;
        while (!flag){
            if (arr[i] != ' '){
                flag = true;
            }
            i++;
        }

        flag = false;
        while (i < input.length()){
            if (input.charAt(i) == ' ' && !flag){
                flag = true;
                count++;
            } else if (input.charAt(i) != ' '){
                flag = false;
            }
            i++;
        }

        if (arr[input.length() - 1] != ' '){
            count++;
        }

        System.out.println(count);
    }
}
