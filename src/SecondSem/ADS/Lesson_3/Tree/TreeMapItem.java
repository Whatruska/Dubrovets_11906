package SecondSem.ADS.Lesson_3.Tree;

public class TreeMapItem<K extends Comparable, V> implements Comparable {
    private K key;
    private V value;

    public TreeMapItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        TreeMapItem<K,V> item = (TreeMapItem<K,V>) o;
        return key.compareTo(item.key);
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
