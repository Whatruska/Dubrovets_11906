package Tutor;

import java.util.Scanner;

public class acmp {
    private static final int FORMAT_SIGNS = 6;
    private static final int NULL_CODE = (int) '0';
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double D = 0;
        double x1 = 0, x2 = 0, x = 0;
        int count = 0;
        if ((a != 0) && (b != 0) && (c != 0)) {
            D = Math.sqrt((b * b) - (4 * a * c));
            if (D > 0) {
                x1 = (-b - D) / (2 * a);
                x2 = (-b + D) / (2 * a);
                count = 2;
                System.out.println(count);
                System.out.println(formatDouble(x1));
                System.out.println(formatDouble(x2));
            } else if (D == 0) {
                x = -b / (2 * a);
                count = 1;
                System.out.println(count);
                System.out.println(formatDouble(x));
            }
        } else if ((a == 0) && (b == 0) && (c == 0)) {
            count = -1;
            System.out.println(count);
        } else if ((a == 0) && (b != 0)) {
            x = -c / b;
            count = 1;
            System.out.println(count);
            System.out.println(formatDouble(x));
        } else if ((a == 0) && (b == 0)) {
            count = 0;
            System.out.println(count);
        }
    }

    private static String formatDouble(double d){
        String sign = d < 0 ? "-" : "";
        return sign + round(addNulls(Math.abs(d) + ""));
    }

    private static String addNulls(String str){
        int length = str.length();
        int index = str.indexOf('.');
        StringBuilder builder = new StringBuilder(str);
        for (int i = length - index; i < FORMAT_SIGNS; i++){
            builder.append('0');
        }

        return builder.toString();
    }

    private static String round(String str){
        int index = str.indexOf('.');
        if (str.length() - index > FORMAT_SIGNS) {
            int digit = str.charAt(FORMAT_SIGNS + index) - NULL_CODE;
            digit = str.charAt(FORMAT_SIGNS + index + 1) > 5 ? digit + 1 : digit;
            if (digit == 10) {
                digit = 9;
            }
            String text = "";
            for (int i = 0; i < FORMAT_SIGNS + index; i++) {
                text += str.charAt(i);
            }
            text += digit;
            return text;
        } else {
            return str;
        }
    }
}
