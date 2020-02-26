package SecondSem.Informatics.Lesson_3;

import SecondSem.Informatics.Lesson_2.List;
import SecondSem.Informatics.Lesson_2.ListElement;

import java.util.Scanner;

public class Main {
    
    private static List<String> stringList = new List<>("");
    public static final String STP_CMD = "stp";
    public static final String ADD_CMD = "add";
    public static final String RPL_CMD = "rpl";
    public static final String DEL_CMD = "del";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.equals(STP_CMD)){
            stringList.push(str);
            str = scanner.nextLine();
        }
        str = scanner.nextLine();
        stringList.deleteHead();
        while (!str.equals(STP_CMD)){
            executeCommand(str);
            str = scanner.nextLine();
        }
        stringList.printList();
    }

    public static void executeCommand(String str){
        String[] parts = str.split("\\s+");
        if (parts.length < 2){
            throw new IllegalArgumentException("Введи нормально команду, вна2ре");
        }
        String cmd = parts[0];
        String arg = parts[1];
        if (cmd.equals(ADD_CMD)){
            add(stringList, arg);
        } else if (cmd.equals(RPL_CMD)){
            if (parts.length < 3){
                throw new IllegalArgumentException("Введи нормально команду, вна2ре");
            }
            String repl = parts[2];
            replace(stringList, arg, repl);
        } else if (cmd.equals(DEL_CMD)){
            delete(stringList, arg);
        }
    }

    private static void replace(List<String> stringList, String arg, String repl) {
        List<Integer> indexes = stringList.findAllIndexesOfValues(arg);
        ListElement<Integer> elem = indexes.getHead();
        while (elem != null){
            stringList.get(elem.getValue()).setValue(repl);
            elem = elem.getNext();
        }
    }

    private static void delete(List<String> stringList, String arg) {
        List<Integer> indexes = stringList.findAllIndexesOfValues(arg);
        ListElement<Integer> elem = indexes.getHead();
        while (elem != null){
            stringList.deleteNextElem(elem.getValue() - 1);
            elem = elem.getNext();
        }
    }

    private static void add(List<String> stringList, String arg) {
        stringList.push(arg);
    }
}
