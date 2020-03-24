package SecondSem.ADS.Lesson_7;

import java.util.Scanner;
import java.util.TreeMap;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++){
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++){
                String id = scanner.next();
                if (map.containsKey(id)){
                    map.put(id, map.get(id) + 1);
                } else {
                    map.put(id, 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        String maxId = "";
        for (String id : map.keySet()){
            int users = map.get(id);
            if (users > max){
                maxId = id;
            }
        }
        System.out.println(maxId);
    }
}
