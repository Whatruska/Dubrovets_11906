package Semester_Works.Semester_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomGen {
    public static void generateInput() throws FileNotFoundException {
        File file = new File("src/Semester_Works/Semester_2/Texts/input.txt");
        PrintWriter writer = new PrintWriter(file);
        Random random = new Random();

        int n = random.nextInt(50) + 50;
        writer.println(n);
        for (int i = 0; i < n; i++){
            String s = getSet();
            writer.println(s);
        }

        writer.close();
    }

    public static String getSet(){
        Random random = new Random();
        int size = random.nextInt(10000 - 100) + 100;
        String res = size + " ";
        for (int i = 0; i < size; i++){
            int elem = random.nextInt(10000);
            res += elem + " ";
        }
        return res;
    }
}
