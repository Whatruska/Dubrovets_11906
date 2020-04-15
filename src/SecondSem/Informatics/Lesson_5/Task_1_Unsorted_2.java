package SecondSem.Informatics.Lesson_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Task_1_Unsorted_2 {
    private static final String publicPath = "src/SecondSem/Informatics/Lesson_5/Files/";
    public static void main(String[] args) throws IOException {
        File file = Paths.get(publicPath + "teachers.txt").toFile();
        BufferedReader teachersReader = new BufferedReader(new FileReader(file));
        String line = teachersReader.readLine();
        while (line != null){
            StringTokenizer tokenizer = new StringTokenizer(line);
            String surname = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            String patronym = tokenizer.nextToken();
            String group = tokenizer.nextToken();
            System.out.println("Группа " + group);
            System.out.println("Преподаватель : " + surname + " " + name + " " + patronym);
            File studfile = Paths.get(publicPath + "students.txt").toFile();
            BufferedReader studReader = new BufferedReader(new FileReader(studfile));
            String studLine = studReader.readLine();
            while (studLine != null){
                StringTokenizer tok = new StringTokenizer(studLine);
                String studSurname = tok.nextToken();
                String studName = tok.nextToken();
                String studPatronym = tok.nextToken();
                String studGroup = tok.nextToken();
                if (studGroup.equals(group)){
                    System.out.println(studSurname + " " + studName + " " + studPatronym);
                }
                studLine = studReader.readLine();
            }
            line = teachersReader.readLine();
        }
    }
}
