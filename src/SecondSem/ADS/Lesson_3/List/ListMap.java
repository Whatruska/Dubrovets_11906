package SecondSem.ADS.Lesson_3.List;

import SecondSem.Informatics.Lesson_2.List;
import SecondSem.Informatics.Lesson_2.ListElement;

public class ListMap<K,V> {
    private List<ListMapItem<K,V>> mapList = new List<>();

    public V get (K key){
        ListMapItem<K, V> item = find(key);
        if (item == null){
            return null;
        }
        return item.getValue();
    }

    public int size() {
        ListElement<ListMapItem<K,V>> item = mapList.getHead();
        int count = 0;
        while (item != null){
            ListMapItem<K,V> listMapItem = item.getValue();
            if (listMapItem.getKey() != null && listMapItem.getValue() != null){
                count++;
            }
            item = item.getNext();
        }
        return count;
    }

    public ListMapItem<K,V> find (K key){
        ListElement<ListMapItem<K,V>> item = mapList.getHead();
        while (item != null){
            ListMapItem<K,V> listMapItem = item.getValue();
            if (listMapItem.getKey().equals(key)){
                return listMapItem;
            }
            item = item.getNext();
        }
        return null;
    }

    public void put(K key, V value){
        ListElement<ListMapItem<K,V>> item = mapList.getHead();
        boolean isChanged = false;
        while (item != null) {
            ListMapItem<K,V> listMapItem = item.getValue();
            if (listMapItem.getKey().equals(key)){
                listMapItem.setValue(value);
                isChanged = true;
            }
            item = item.getNext();
        }
        if (!isChanged){
            mapList.push(new ListMapItem<>(key, value));
        }
    }

}
