package SecondSem.Tutor;

import java.util.Collection;
import java.util.Iterator;

public class IntegerArrayCollection implements java.util.Collection<Integer> {

    private int[] array;
    private int capacity;
    private int size;

    public IntegerArrayCollection() {
        capacity = 1000;
        size = 0;
        array = new int[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
        //return (size == 0);
    }

    @Override
    public boolean contains(Object o ) {
        for (int i = 0; i < size; i++) {
            if (array[i] == (int)o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index <= size - 1;
            }

            @Override
            public Integer next() {
                Integer result = array[index];
                index++;
                return result;
            }
        };
    }

    @Override
    public Integer [] toArray() {
        Integer [] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer x) {
        if (size < capacity) {
            array[size] = x;
            size++;
            return true;
        } else {
            this.capacity = 2 * capacity;
            int [] array2 = new int [capacity];
            for (int i = 0; i < size; i++) {
                array2[i] = array[i];
            }
            array2[size] = x;
            size++;
            this.array = array2;
            return true;
        }
        //capacity?????
    }

    @Override
    public boolean remove(Object o) {
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == (int) o) {
                array[i] = 0;
                k = i;
                break;
            }
        }
        int [] array2 = new int [size - 1];
        for (int i = 0; i < k; i++) {
            array2[i] = array[i];
        }
        for (int j = k; j < size - 1; j++) {
            array2[j] = array[j + 1];
        }
        array = array2;
        return true;
    }
    // + (contains)
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object name : c) {
            if (!contains(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer y : c){
            add(y);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object name : c) {
            remove(name);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) { //удалиить все каких нет в с
        for (Object name : c) {
            if (!contains(name)) {
                remove(name);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        /*for (int i = 0; i < size; i++) {
            remove(array[i]);
        }*/
        array = new int [capacity];
        size = 0;
    }
}
