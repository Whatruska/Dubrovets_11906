package SecondSem.ADS.Lesson_8;

import java.util.*;

public class Task_1 {
    static HashMap<String, TreeSet<String>> usersMap = new HashMap<>();
    static HashMap<String, TreeSet<String>> sitesMap = new HashMap<>();
    static HashMap<Integer, LinkedList<String>> popularity = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int requests = scanner.nextInt();
        for (int i = 0; i < requests; i++){
            int n = scanner.nextInt();
            switch (n){
                case 0 : {
                    input();
                    break;
                }
                case 1 : {
                    printUsers(usersMap);
                    break;
                }
                case 2 : {
                    printSites(sitesMap);
                    break;
                }
                case 3 : {
                    printMostPopularSites();
                    break;
                }
                case 4 : {
                    printFrequency();
                    break;
                }
                default:{break;}
            }
        }
    }

    public static void input(){
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++){
            String user = scanner.next();
            String site = scanner.next();
            refreshPopularity(site);
            refreshUsers(user, site);
            refreshSites(user, site);
        }
    }

    public static boolean containsSite(String site){
        for (Integer visit : popularity.keySet()){
            LinkedList<String> sites = popularity.get(visit);
            for (String elem : sites){
                if (elem.equals(site)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void printUsers(Map<String, TreeSet<String>> map){
        System.out.println("-----PRINT_USERS-----");
        for (String key : map.keySet()){
            System.out.print(key + " : ");
            TreeSet<String> set = map.get(key);
            int size = set.size();
            int count = 0;
            for (String setElem : set){
                System.out.print(setElem + " ");
                if (count != size - 1){
                    System.out.print(",");
                }
                count++;
            }
            System.out.println();
        }
    }

    public static void printSites(Map<String, TreeSet<String>> map){
        System.out.println("-----PRINT_SITES-----");
        for (String key : map.keySet()){
            System.out.print(key + " : ");
            TreeSet<String> set = map.get(key);
            System.out.println(set.size());
        }
    }

    public static void printMostPopularSites(){
        System.out.println("-----MOST_POPULAR-----");
        int max = -1;
        for (Integer people : popularity.keySet()){
            LinkedList<String> list = popularity.get(people);
            if (list.size() > 0){
                max = people;
            }
        }
        LinkedList<String> sites = popularity.get(max);
        for (String site : sites){
            System.out.println(site);
        }
    }

    public static void printFrequency(){
        System.out.println("-----PRINT_FREQUENCY-----");
        for (Integer people : popularity.keySet()){
            LinkedList<String> list = popularity.get(people);
            for (String site : list){
                System.out.println(people + " : " + site);
            }
        }
    }

    public static void refreshPopularity(String site){
        if (containsSite(site)){
            for (Integer visitors : popularity.keySet()){
                if (popularity.get(visitors).contains(site)){
                    LinkedList<String> list = popularity.get(visitors);
                    list.remove(site);
                    popularity.put(visitors, list);
                    LinkedList<String> list2 = popularity.get(visitors + 1);
                    if (list2 == null){
                        list2 = new LinkedList<>();
                    }
                    list2.add(site);
                    popularity.put(visitors + 1, list2);
                    break;
                }
            }
        } else {
            LinkedList<String> sites = popularity.get(1);
            if (sites == null){
                sites = new LinkedList<>();
            }
            sites.add(site);
            popularity.put(1, sites);
        }
    }

    public static void refreshUsers(String user, String site){
        TreeSet<String> sitesList = usersMap.get(user);
        if (sitesList == null){
            sitesList = new TreeSet<>();
        }
        sitesList.add(site);
        usersMap.put(user, sitesList);
    }

    public static void refreshSites(String user, String site){
        TreeSet<String> usersList = sitesMap.get(site);
        if (usersList == null){
            usersList = new TreeSet<>();
        }
        usersList.add(user);
        sitesMap.put(site, usersList);
    }
}
