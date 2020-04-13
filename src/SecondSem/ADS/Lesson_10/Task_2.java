package SecondSem.ADS.Lesson_10;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Task_2 {
    private static String strPath = "src/SecondSem/ADS/Lesson_10/Task_1_files";
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(strPath + "Cheb.txt");
        File file1 = path.toFile();
        path = Paths.get(strPath + "Krok.txt");
        File file2 = path.toFile();
        File[] files = {file1, file2};

        int[][] matrix = new int[2][];
        for (int i = 0; i < files.length; i++){
            int freeIndex = 0;
            BufferedReader reader = new BufferedReader(new FileReader(files[i]));
            String line = reader.readLine();
            while (line != null){
                StringTokenizer token = new StringTokenizer(line);
                int size = token.countTokens();
                matrix[i] = new int[size];
                for (int j = 0; j < size; j++){
                    matrix[i][freeIndex++] = Integer.parseInt(token.nextToken());
                }
                line = reader.readLine();
            }
            reader.close();
        }

        int[] resultArr = new int[Math.max(matrix[0][matrix[0].length - 1], matrix[1][matrix[1].length - 1])];
        int[] arr1 = matrix[0];
        int[] arr2 = matrix[1];
        for (int i = 0; i < arr1.length; i++){
            resultArr[arr1[i] - 1]++;
        }
        for (int i = 0; i < arr2.length; i++){
            resultArr[arr2[i] - 1]++;
        }

        int count = 0;
        for (int k = 0; k < resultArr.length; k++){
            if (resultArr[k] > 0){
                count++;
            }
        }

        System.out.println(count);
    }
}
