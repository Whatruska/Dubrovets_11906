package SecondSem.Informatics.Lesson_5;

import java.io.*;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Task1_Sorted {
    private static final String publicPath = "src/SecondSem/Informatics/Lesson_5/Files/";

    public static void main(String[] args) throws IOException {
        File file = Paths.get(publicPath + "teachers.txt").toFile();
        BufferedReader teacherReader = new BufferedReader(new FileReader(file));
        file = Paths.get(publicPath + "students.txt").toFile();
        BufferedReader studentsReader = new BufferedReader(new FileReader(file));
        String teacherLine =teacherReader.readLine();
        String studentLine = studentsReader.readLine();
        while (teacherLine != null){
            StringTokenizer tokenizer = new StringTokenizer(teacherLine);
            String surname = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            String patronym = tokenizer.nextToken();
            String group = tokenizer.nextToken();
            System.out.println("Группа " + group);
            System.out.println("Преподаватель : " + surname + " " + name + " " + patronym);
            if (studentLine != null){
                StringTokenizer studToken = new StringTokenizer(studentLine);
                String studentSurname = studToken.nextToken();
                String studentName = studToken.nextToken();
                String studentPatronym = studToken.nextToken();
                String studentGroup = studToken.nextToken();
                while (studentGroup.equals(group) && studentLine != null){
                    System.out.println(studentSurname + " " + studentName + " " + studentPatronym);
                    studentLine = studentsReader.readLine();
                    if (studentLine != null){
                        studToken = new StringTokenizer(studentLine);
                        studentSurname = studToken.nextToken();
                        studentName = studToken.nextToken();
                        studentPatronym = studToken.nextToken();
                        studentGroup = studToken.nextToken();
                    }
                }
            }
            teacherLine = teacherReader.readLine();
        }
    }
}
