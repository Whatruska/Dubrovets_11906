package SecondSem.ADS.Lesson_10;

import SecondSem.ADS.Lesson_3.Hash.HashSet;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Task_1 {
    private static String strPath = "src/SecondSem/ADS/Lesson_10/";
    public static void main(String[] args) throws IOException {
        TreeSet<Integer> set = new TreeSet<>();
        Path path = Paths.get(strPath + "Cheb.txt");
        File file = path.toFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null){
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()){
                set.add(Integer.parseInt(tokenizer.nextToken()));
            }
            line = reader.readLine();
        }

        path = Paths.get(strPath + "Krok.txt");
        file = path.toFile();
        reader =  new BufferedReader(new FileReader(file));
        line = reader.readLine();
        while (line != null){
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()){
                set.add(Integer.parseInt(tokenizer.nextToken()));
            }
            line = reader.readLine();
        }

        System.out.println(set.size());
        reader.close();
    }
}
