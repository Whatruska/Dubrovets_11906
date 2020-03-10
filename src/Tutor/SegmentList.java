package Tutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class SegmentList {
    TreeSet<Segment> segments;
    SegmentList(String filename){
        //Считываешь все из файла
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()){
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                segments.add(new Segment());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
