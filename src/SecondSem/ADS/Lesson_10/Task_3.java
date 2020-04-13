package SecondSem.ADS.Lesson_10;

import SecondSem.ADS.Lesson_10.Task_3_files.TimePair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Task_3 {
    private static String strPath = "src/SecondSem/ADS/Lesson_10/Task_3_files/";
    public static void main(String[] args) throws IOException {
        ArrayList<TimePair> result = new ArrayList<>();

        Path path = Paths.get(strPath + "processors.txt");
        File file1 = path.toFile();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String line = reader.readLine();

        int count = 0;
        TimeStamp stamp1 = new TimeStamp();
        TimeStamp stamp2 = new TimeStamp();
        TimeStamp minTimeStamp = new TimeStamp();
        TimePair[] pairs = new TimePair[2];
        while (line != null){
            if (count % 2 == 0){
                stamp1 = new TimeStamp(line);
            } else {
                stamp2 = new TimeStamp(line);
                
            }
            line = reader.readLine();
            count++;
        }

        for (int i = 1; i < result.size(); i++){
            TimePair pair1 = result.get(i - 1);
            TimePair pair2 = result.get(i);
            TimeStamp endStamp = pair2.getStamp1();
            TimeStamp startStamp = pair1.getStamp2();
            if (endStamp.compareTo(startStamp) < 0){
                if (endStamp.compareTo(pair1.getStamp1()) > 0){
                    System.out.println(endStamp);
                } else {
                    System.out.println(startStamp);
                }
            }
        }
    }
}
