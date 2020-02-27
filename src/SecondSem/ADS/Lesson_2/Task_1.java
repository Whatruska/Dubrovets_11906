package SecondSem.ADS.Lesson_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Scanner scanner = new Scanner(new File(getPathTo("input.txt")));
        int k = scanner.nextInt();
        int[][] matrix = new int[k][];
        for (int i = 0; i < k; i++){
            int l = scanner.nextInt();
            matrix[i] = new int[l];
            for (int j = 0; j < l; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[] res = new int[0];
        for (int i = 0; i < matrix.length; i++){
            res = merge(matrix);
        }

        for (int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

    //M = O(k)
    //T = O(N)
    public static int[] merge(int[][] matrix){
        int[] res = new int[getElemCount(matrix)];
        int[] indexes = new int[matrix.length];
        int minLink = getMinLinkIndex(matrix, indexes);
        int k = 0;
        while (minLink != -1){
            res[k] = matrix[minLink][indexes[minLink]];
            indexes[minLink]++;
            minLink = getMinLinkIndex(matrix,indexes);
            k++;
        }
        return res;
    }

    //T = O(k)
    //M = O(1)
    public static int getElemCount(int[][] matrix){
        int count = 0;
        for (int i = 0; i < matrix.length; i++){
            count += matrix[i].length;
        }
        return count;
    }

    //T = O(k)
    //M = O(1)
    public static int getMinLinkIndex(int[][] matrix, int[] indexes){
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        for (int i = 0; i < indexes.length; i++){
            if (indexes[i] < matrix[i].length) {
                int value = matrix[i][indexes[i]];
                if (value < min) {
                    min = value;
                    minInd = i;
                }
            }
        }
        return minInd;
    }

    private static URI getPathTo(String str) throws URISyntaxException {
        return Paths.get(Task_1.class.getResource(str).toURI()).toUri();
    }
}
