package SecondSem.ADS.Lesson_3.List;

public class ListSet<K> {

    private ListMap<K, Object> set = new ListMap<>();

    public void add(K key){
        if (!contains(key)){
            set.put(key, new Object());
        }
    }

    public void remove(K key){
        ListMapItem<K, Object> item = set.find(key);
        set.put(item.getKey(), null);
    }

    public boolean contains(K key){
        return set.find(key) != null;
    }
}
