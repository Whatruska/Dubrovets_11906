package SecondSem.ADS.Lesson_3.Tree;

public class TreeMap<K extends Comparable, V> {
    TreeList<TreeMapItem<K, V>> mapList = new TreeList<>();

    public TreeMapItem<K,V> get (K key){
        TreeElement<TreeMapItem<K, V>> elem = mapList.get(new TreeMapItem<>(key, (V)new Object()));
        return elem == null ? null : elem.getValue();
    }

    public int size(){
        return mapList.getSize();
    }

    public void put(K key, V value){
        TreeMapItem<K, V> element = get(key);
        if (element != null){
            mapList.remove(element);
            element.setValue(value);
        } else {
            element = new TreeMapItem<>(key, value);
        }
        if (value != null){
            mapList.push(element);
        }
    }

    public void remove(K key){
        mapList.remove(new TreeMapItem<>(key, (V) new Object()));
    }
}
