package Tutor;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        File file = new File(Main.class.getResource("input.txt").toURI());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            TreeSet<String> phones = new TreeSet<>();
            if (str.matches("\\+?7\\s*\\(?[0-9]{1,3}\\)?\\s*[0-9]{1,3}[\\-\\s]?[0-9]{1,2}[\\-\\s]?[0-9]{1,2}\\s+[А-Яа-я]+")){
                phones.add(str);
            }
            for (Object string : phones.toArray()){
                System.out.println(string);
            }
        }
    }
}
