package SecondSem.ADS.Lesson_3.Hash;

import SecondSem.ADS.Lesson_3.Array.ArrayMap;
import SecondSem.ADS.Lesson_3.List.ListMap;

public class HashMap<K, V> {
    public static final int MAX_HASH = 1000;

    private ArrayMap<Integer, ListMap<K, V>> map = new ArrayMap<>(MAX_HASH);
    private int size = 0;

    public HashMap() {

    }

    public int getSize(){
        return size;
    }

    public boolean isValidKey(K key){
        int k = key.hashCode() % MAX_HASH;
        return k > 0;
    }

    public ListMap<K,V> get (K key){
        int code = key.hashCode() % MAX_HASH;
        if (isValidKey(key)){
            return map.get(code);
        }
        return null;
    }

    public void put (K key, V value){
        int code = key.hashCode() % MAX_HASH;
        ListMap<K, V> elem = map.get(code);
        if (elem == null || elem.size() == 0){
            elem = new ListMap<>();
            size++;
        }
        elem.put(key, value);
        map.put(code, elem);
    }
}
