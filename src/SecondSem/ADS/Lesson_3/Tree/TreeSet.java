package SecondSem.ADS.Lesson_3.Tree;

public class TreeSet<K extends Comparable> {
    TreeMap<K, Object> map = new TreeMap<>();

    public void add(K key){
        map.put(key, new Object());
    }

    public boolean contains(K key){
        return map.get(key) != null;
    }

    public void remove(K key){
        map.put(key, null);
    }
}
