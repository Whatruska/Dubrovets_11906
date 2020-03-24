package SecondSem.ADS.Lesson_7;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedList<Integer>> map = new TreeMap<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++){
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++){
                String id = scanner.next();
                LinkedList<Integer> list;
                if (map.containsKey(id)){
                    list = map.get(id);
                } else {
                    list = new LinkedList<>();
                }
                list.add(i + 1);
                map.put(id, list);
            }
        }
        for (String id : map.keySet()){
            LinkedList<Integer> groups = map.get(id);
            System.out.print(id + " : ");
            for (Integer group : groups){
                System.out.print(group + " , ");
            }
            System.out.println();
        }
    }
}
