package SecondSem.ADS.Lesson_12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomGen {
    private static final int count = 10;
    public static void writeRandomOnFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(Task_1.PATH_TO_FILE + filename + ".txt")));
        for (int i = 0; i < count; i++){
            writer.append(getRandomString() + "\n");
        }
        writer.close();
    }

    public static String getRandomString(){
        long p = getNewNum();
        long a = getNewNum();
        while (a >= p || a == 0){
            a = getNewNum();
        }
        long b = getNewNum();
        while (b == 0){
            b = getNewNum();
        }
        long d = getNewNum();
        while (d == 0){
            d = getNewNum();
        }
        return  " " + a + " " + b + " " + d + " " + p;
    }

    public static long getNewNum(){
        int bound = 100;
        Random random = new Random();
        return Math.abs(random.nextInt(bound));
    }
}
