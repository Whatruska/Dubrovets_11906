package SecondSem.ADS.Lesson_3.List;

public class ListMapItem<K, V> {
    private K key;
    private V value;

    public ListMapItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
