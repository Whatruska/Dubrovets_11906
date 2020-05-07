package SecondSem.ADS.Lessson_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Task_1 {
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
        System.out.println(fileNames.stream().filter(name -> name.startsWith("c:/users/" + finalUser)).count());
    }
}
