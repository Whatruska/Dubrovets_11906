package SecondSem.Informatics.Lesson_4;

import SecondSem.Informatics.Lesson_2.List;
import SecondSem.Informatics.Lesson_2.ListElement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final String BOY_CLASS = "BOY";
    private static final String GIRL_CLASS = "GIRL";

    private static final String DO_EXC_CMD = "exc";
    private static final String CHECK_FIL_CMD = "fil";
    private static final String CHECK_SUPER_CMD = "super";
    private static final String HELP_CMD = "help";

    public static void main(String[] args) {
        StudentList<Student> girlList = inputAndFormList(GIRL_CLASS);
        StudentList<Student> boyList = inputAndFormList(BOY_CLASS);
        StudentList<Student> sortedList = mergeLists(boyList, girlList);
        String empty = scanner.nextLine();
        String cmd = scanner.nextLine();
        while (executeCommand(cmd, sortedList)){
            cmd = scanner.nextLine();
        }
    }

    public static StudentList<Student> inputAndFormList(String c) throws IllegalArgumentException{
        StudentList<Student> result = new StudentList<Student>(new Boy(32));
        System.out.println("Введите рост " + (c.equals(BOY_CLASS) ? "мальчиков" : "девочек"));
        int heigth = scanner.nextInt();
        while (heigth != -1){
            Student stud;
            if (c.equals(BOY_CLASS)){
                stud = new Boy(heigth);
            } else if (c.equals(GIRL_CLASS)){
                stud = new Girl(heigth);
            } else {
                throw new IllegalArgumentException("Неверно введен создаваемый класс");
            }
            result.push(stud);
            heigth = scanner.nextInt();
        }
        result.deleteHead();
        return result;
    }

    public static StudentList<Student> mergeLists(StudentList<Student> list1, StudentList<Student> list2){
        ListElement<Student> link1 = list1.getHead();
        ListElement<Student> link2 = list2.getHead();

        StudentList<Student> result = new StudentList<>(new Boy(32));
        while (link1 != null && link2 != null){
            int height1 = link1.getValue().getHeight();
            int height2 = link2.getValue().getHeight();

            if (height1 <= height2){
                result.push(link1.getValue());
                link1 = link1.getNext();
            } else {
                result.push(link2.getValue());
                link2 = link2.getNext();
            }
        }

        while (link1 != null){
            result.push(link1.getValue());
            link1 = link1.getNext();
        }

        while (link2 != null){
            result.push(link2.getValue());
            link2 = link2.getNext();
        }

        result.deleteHead();
        return result;
    }

    public static boolean executeCommand(String command, StudentList<Student> list){
        String[] parts = command.split("\\s+");
        if(parts.length < 1){
            throw new InputMismatchException("Неверный ввод команды");
        }

        String cmd = parts[0];
        switch (cmd){
            case DO_EXC_CMD : {
                int arg1 = Integer.parseInt(parts[1]);
                int arg2 = Integer.parseInt(parts[2]);
                return doExc(list, arg1, arg2);
            }

            case CHECK_FIL_CMD : {
                return list.checkFiloming();
            }

            case CHECK_SUPER_CMD : {
                return list.checkSuperStudent();
            }

            case HELP_CMD : {
                System.out.println(DO_EXC_CMD + " - выполнить упражнения");
                System.out.println(CHECK_FIL_CMD + " - проверить филонящих");
                System.out.println(CHECK_SUPER_CMD + " - проверить студентов");
                return true;
            }

            default: {
                throw new InputMismatchException("Не найдено такой команды");
            }
        }
    }

    public static boolean doExc(StudentList<Student> list, int from, int to){
        list.doExcercise(from,to);
        return true;
    }
}
