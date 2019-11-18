package Boolean_Func;

import java.util.Scanner;

public class BooleanFunc {

    private static void buildSDNF(String vector){
        System.out.println("СДНФ");
        int count = countSynbolsInString(vector, '1');
        int sign = log2(vector.length());
        for (int i = 0; i < vector.length(); i++){
            String bitString = convertToBitString(i, sign);
            if (vector.charAt(i) == '1') {
                for (int j = 0; j < bitString.length(); j++) {
                    char ch = bitString.charAt(j);
                    if (ch == '0') {
                        System.out.print("¬");
                    }
                    System.out.print("x" + j);
                }
                if (count > 1){
                    count--;
                    System.out.print(" V ");
                }
            }
        }
        System.out.println();
    }

    private static void buildSKNF(String vector){
        System.out.println("СКНФ");
        int count = countSynbolsInString(vector, '0');
        int sign = log2(vector.length());
        for (int i = 0; i < vector.length(); i++){
            String bitString = convertToBitString(i, sign);
            if (vector.charAt(i) == '0') {
                for (int j = 0; j < bitString.length(); j++) {
                    char ch = bitString.charAt(j);
                    if (ch == '1') {
                        System.out.print("¬");
                    }
                    System.out.print("x" + j);
                    if (j < bitString.length() - 1){
                        System.out.print("V");
                    }
                }
                if (count > 1){
                    count--;
                    System.out.print(" * ");
                }
            }
        }
        System.out.println();
    }

    public static int countSynbolsInString(String string, char ch){
        int count = 0;
        for (char cha : string.toCharArray()){
            if (cha == ch){
                count++;
            }
        }
        return count;
    }

    public static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    private static boolean isTwoInFactor(int num){
        int checkNum = 1;
        while (checkNum <= num){
            if (checkNum == num){
                return true;
            }
            checkNum *= 2;
        }
        return false;
    }

    private static String convertToBitString(int num, int signs){
        StringBuilder builder = new StringBuilder();
        while (num > 0){
            builder.append(num % 2);
            num /= 2;
        }
        for (int i = builder.toString().length(); i < signs; i++){
            builder.append(0);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вектор значений : ");
        String rawVector = scanner.nextLine();
        String vector = rawVector.replaceAll("\\s+", "");
        if (!isTwoInFactor(vector.length())){
            System.out.println("Неверно введен вектор значений");
        } else {
            buildSDNF(vector);
            buildSKNF(vector);
        }
    }
}
