package SecondSem.ADS.Lesson_3.Array;

public class ArrayMap<K extends Integer, V> {
    public static final int DEFAULT_CAPACITY = 1000;

    private Object[] arr;
    private int size = 0;
    private int d = 0;

    public ArrayMap(int diapason) {
        d = diapason;
        arr = new Object[diapason];
    }

    public ArrayMap() {
        this(DEFAULT_CAPACITY);
    }

    public int getSize(){
        return size;
    }

    public boolean isValidKey(K key){
        int k = key;
        return k > 0 && k < d;
    }

    public V get(K key){
        int intKey = key;
        if (isValidKey(key)){
            return (V) arr[intKey];
        }
        return null;
    }

    public void put(K key, V value){
        int k = key;
        if (isValidKey(key)){
            if (arr[k] == null){
                size++;
            }
            arr[k] = value;
        }
    }
}
