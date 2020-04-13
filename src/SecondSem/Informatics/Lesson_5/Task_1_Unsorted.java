package SecondSem.Informatics.Lesson_5;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Task_1_Unsorted {
    private static final String publicPath = "src/SecondSem/Informatics/Lesson_5/Files/";
    public static void main(String[] args) throws IOException {
        File file = Paths.get(publicPath + "teachers.txt").toFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        TreeMap<String, Human> groupToTeacherMap = new TreeMap<>();
        while (line != null){
            StringTokenizer tokenizer = new StringTokenizer(line);
            String surname = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            String patronym = tokenizer.nextToken();
            String group = tokenizer.nextToken();
            groupToTeacherMap.put(group, new Human(surname + " " + name + " " + patronym));
            line = reader.readLine();
        }
        file = Paths.get(publicPath + "students.txt").toFile();
        reader = new BufferedReader(new FileReader(file));
        line = reader.readLine();
        HashSet<Human> studentsSet = new HashSet<>();
        while (line != null){
            StringTokenizer tokenizer = new StringTokenizer(line);
            String surname = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            String patronym = tokenizer.nextToken();
            String group = tokenizer.nextToken();
            studentsSet.add(new Human(surname + " " + name + " " + patronym, group));
            line = reader.readLine();
        }

//        for (String group : groupToTeacherMap.keySet()){
//            Human teacher = groupToTeacherMap.get(group);
//            System.out.println("Группа " + group);
//            System.out.println("Преподаватель : " + teacher.getFullName());
//            for (Human student : studentsSet){
//                if (student.getGroup().equals(group)){
//                    System.out.println(student.getFullName());
//                }
//            }
//            System.out.println("-----------------------");
//        }

        groupToTeacherMap.keySet().forEach((group) -> {
            System.out.println("Группа " + group);
            System.out.println("Преподаватель : " + groupToTeacherMap.get(group).getFullName());
            studentsSet.stream().filter(student -> student.getGroup().equals(group)).forEach(student -> System.out.println(student.getFullName()));
            System.out.println("---------------");
        });
    }
}
