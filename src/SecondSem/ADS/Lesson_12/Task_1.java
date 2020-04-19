package SecondSem.ADS.Lesson_12;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task_1 {
    public static final String PATH_TO_FILE = "src/SecondSem/ADS/Lesson_12/Tests/";
    public static void main(String[] args) throws IOException {
        RandomGen.writeRandomOnFile("input");
        BufferedReader reader = new BufferedReader(new FileReader(new File(PATH_TO_FILE + "input.txt")));
        String line = reader.readLine();
        if (line != null){
            line = line.trim();
        }
        while (line != null){
            StringTokenizer token = new StringTokenizer(line);
            long a = Long.parseLong(token.nextToken());
            long b = Long.parseLong(token.nextToken());
            long d = Long.parseLong(token.nextToken());
            long p = Long.parseLong(token.nextToken());
            long[] indexes = new long[(int) p];
            int freeIndex = 0;
            Arrays.fill(indexes, -1);
            int countPerCycle = 0;
            System.out.println("Full");
            for (long c = 0; c <= d; c++){
                long res = (b * c) % p;
                System.out.print(res + " ");
            }
            System.out.println();
            System.out.println("Cycle");
            for (long c = 0; c < Math.min(d,p); c++){
                long res = (b * c) % p;
                System.out.print(res + " ");
                if (res == a){
                    indexes[freeIndex++] = c;
                    countPerCycle++;
                }
            }
            System.out.println();
            System.out.println("A : " + a);
            System.out.println("Count " + a + " : " + countPerCycle);
            long cycles = (d + 1) / p;
            System.out.println("Cycles : " + (d + 1) / p);
            long ost = (d + 1) - (d + 1) / p * p;
            System.out.println("Ost : " + ost);
            long count = countPerCycle * cycles;
            int i = 0;
            while (i < indexes.length && indexes[i] != -1){
                if (indexes[i] <= ost) count++;
                i++;
            }
            System.out.println("Total count : " + count);
            System.out.println("======================");
            line = reader.readLine();
            if (line != null){
                line = line.trim();
            }
        }
        reader.close();
    }
}
