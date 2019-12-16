package Lesson_13;

import java.util.Scanner;

public class StudentSystem {
    private static DynamicStudentArray array = new DynamicStudentArray(1);
    private static Scanner scanner = new Scanner(System.in);

    private static final String LOGIN = "login";
    private static final String PASS = "password";

    private static final String MATH_STRING = "Матан";
    private static final String ALG_STRING = "Алгем";
    private static final String INFO_STRING = "Инфа";

    private static final String LIST_CMD = "/getList";
    private static final String MARK_CMD = "/mark";
    private static final String STUDENT_CMD = "/newStudent";
    private static final String EXIT_CMD = "/exit";

    public static void start(){
        login();
        String command = getStringAttr("Команду");
        while (!command.equalsIgnoreCase(EXIT_CMD)){
            if (command.equalsIgnoreCase(LIST_CMD)){
                getList();
            } else if (command.equalsIgnoreCase(MARK_CMD)){
                setMark();
            } else if (command.equalsIgnoreCase(STUDENT_CMD)){
                newStudent();
            }
            command = getStringAttr("Команду");
        }
    }

    private static boolean match(String login, String pass){
        return login.equalsIgnoreCase(LOGIN) && pass.equalsIgnoreCase(PASS);
    }

    private static void login(){
        String login = getStringAttr("Логин");
        String password = getStringAttr("Пароль");
        while (!match(login, password)){
            login = getStringAttr("Логин");
            password = getStringAttr("Пароль");
        }
        System.out.println("Добро пожаловать!");
    }

    private static void newStudent(){
        String name = getStringAttr("Имя");
        String surname = getStringAttr("Фамилию");
        String patronym = getStringAttr("Отчество");

        Student student = new Student(name, surname, patronym, "Login", "Password");

        array.addNewStudent(student);
        System.out.println("Студент успешно добавлен");
    }

    public static void getList(){
        for (int i = 0; i < array.size(); i++){
            Student student = array.getStudent(i);
            System.out.println(student.toString());
        }
    }

    private static void setMark(){
        String surname = getStringAttr("Фамилию");
        Student student = array.getStudentBySurname(surname);
        if (student.equals(new Student())){
            System.out.println("Данного студента не существует");
        } else {
            String object = getStringAttr("Предмет");
            int mark = getIntAttr("Оценку");
            Marks marks = student.getMarks();
            if (object.equalsIgnoreCase(MATH_STRING)){
                marks.setMathMark(mark);
            } else if (object.equalsIgnoreCase(INFO_STRING)){
                marks.setInfoMark(mark);
            } else if (object.equalsIgnoreCase(ALG_STRING)){
                marks.setAlgMark(mark);
            } else {
                System.out.println("Неверно введен предмет");
            }
            student.setMarks(marks);
            array.setStudent(student);
        }
    }

    private static String getStringAttr(String attrName){
        System.out.print("Введите " + attrName.toLowerCase() + " : ");
        return scanner.next();
    }

    private static int getIntAttr(String attrName){
        System.out.print("Введите " + attrName.toLowerCase() + " : ");
        return scanner.nextInt();
    }
}
