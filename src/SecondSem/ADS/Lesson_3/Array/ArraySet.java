package SecondSem.ADS.Lesson_3.Array;

public class ArraySet<K extends Integer, V> {
    private ArrayMap<K, V> map;

    public ArraySet(int d) {
        map = new ArrayMap<>(d);
    }

    public ArraySet() {
        map = new ArrayMap<>();
    }

    public void add(K key){
        if (map.isValidKey(key)){
            map.put(key, (V) new Object());
        }
    }

    public boolean contains(K key){
        if (map.isValidKey(key) && map.get(key) != null){
            return true;
        }
        return false;
    }

    public void remove(K key){
        if (map.isValidKey(key)){
            map.put(key, null);
        }
    }
}
