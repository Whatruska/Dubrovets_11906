package FirstSem.Tutor;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rand {
    private static final Pattern INCORRECT_PATTERN = Pattern.compile("[0-9]*([02468]{3})+[0-9]*");
    private static final int COUNTER = 10;

    public static void main(String[] args) {
        Random random = new Random();
        int i = 0;
        while (i < COUNTER){
            String string = Integer.toString(random.nextInt(Integer.MAX_VALUE));
            if (isCorrect(string)){
                System.out.println((i + 1) + " - " + string);
                i++;
            }
        }
    }

    private static boolean isCorrect(String string){
        Matcher m = INCORRECT_PATTERN.matcher(string);
        return !m.matches();
    }
}
