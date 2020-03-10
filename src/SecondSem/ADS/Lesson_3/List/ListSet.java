package SecondSem.ADS.Lesson_3.List;

public class ListSet<K, V> {

    private ListMap<K, V> set;

    public void add(K key){
        if (!contains(key)){
            set.put(key, (V) new Object());
        }
    }

    public void remove(K key){
        ListMapItem<K, V> item = set.find(key);
        set.put(item.getKey(), null);
    }

    public boolean contains(K key){
        return set.find(key) != null;
    }
}
