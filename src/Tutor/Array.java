package Tutor;

import java.util.Objects;

public class Array<T> {
    private T[] source;
    private int freeIndex = 0;

    public Array() {
        source = (T[]) new Object [1];
    }

    public Array(int length){
        source = (T[]) new Object[length];
    }

    public Array(T[] arr){
        source = arr;
    }

    private final boolean isValidIndex(int index){
        return index > -1 && index < source.length;
    }

    private final boolean hasFreeSpace(){
        return isValidIndex(freeIndex);
    }

    private final boolean isFull(){
        return !hasFreeSpace();
    }

    public final void add(T obj){
        if (isFull()){
            increaseCapacity();
        }
        source[freeIndex] = obj;
        freeIndex++;
    }

    private final void increaseCapacity(){
        T[] result = (T[]) new Object[source.length + 1];
        for (int i = 0; i < source.length; i++){
            result[i] = source[i];
        }
        source = result;
    }

    public final T get(int index){
        if (isValidIndex(index)){
            return source[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public final int size(){
        return source.length;
    }

    public final void remove(int index){
        if (isValidIndex(index)){
            source[index] = null;
            shift(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public final void remove(T obj){
        if (contains(obj)){
            remove(indexOf(obj));
        }
    }

    private final void shift(int fromIndex){
        for (int i = fromIndex + 1; i < source.length; i++){
            source[i - 1] = source[i];
        }
        source[source.length - 1] = null;
    }

    public Object[] toArray(){
        int resSize = 0;
        for (int i = 0; i < source.length; i++){
            if (source[i] != null){
                resSize++;
            }
        }
        Object[] array = new Object[resSize];
        for (int i = 0; i < resSize; i++){
            array[i] = source[i];
        }
        return array;
    }

    public boolean contains(T obj){
        if (indexOf(obj) != -1){
            return true;
        }
        return false;
    }

    public void clear(){
        source = (T[]) new Object[0];
    }

    public int indexOf(T obj){
        for (int i = 0; i < source.length; i++){
            if (source[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return source.length == 0;
    }

    public int lastIndex(T obj){
        int index = 0;
        for (int i = 0; i < source.length; i++){
            if (source[i].equals(obj)){
                index = i;
            }
        }
        return index;
    }
}
