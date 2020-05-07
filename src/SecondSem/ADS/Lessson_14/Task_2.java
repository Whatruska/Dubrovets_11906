package SecondSem.ADS.Lessson_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String user = "";
        HashSet<String> fileNames = new HashSet<>();
        while (line != null){
            if (line.contains("/")){
                fileNames.add(line);
            } else {
                user = line;
                break;
            }
            line = reader.readLine();
        }
        String finalUser = user;

        fileNames = (HashSet<String>) fileNames.stream().filter(
                name -> name.matches("c:/users/[a-zA-Z0-9]+/documents/[a-zA-Z0-9]+[a-zA-Z0-9\\/]+[a-zA-Z0-9]+.docx")
        ).collect(Collectors.toSet());
        fileNames.stream().forEach(System.out::println);
    }
}
