package SecondSem.ADS.Lesson_3.Hash;

public class HashSet<K> {
    HashMap<K, Object> map = new HashMap<>();

    public void add (K key){
        if (!contains(key)){
            map.put(key, new Object());
        }
    }

    public boolean contains(K key){
        return map.get(key) != null;
    }

    public void remove(K key){
        map.put(key, null);
    }
}
