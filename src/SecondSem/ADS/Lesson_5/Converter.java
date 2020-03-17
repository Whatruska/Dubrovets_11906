package SecondSem.ADS.Lesson_5;

import SecondSem.Informatics.Lesson_2.List;
import SecondSem.Informatics.Lesson_2.ListElement;

public class Converter {

    public static <T> List<T> convertArrToList(T[] arr){
        List<T> result = new List<>();
        for (T item : arr){
            result.push(item);
        }
        return result;
    }

    public static <T> T[] convertListToArr(List<T> list, T[] arr){
        ListElement<T> elem = list.getHead();
        int k = 0;
        while (elem != null){
            arr[k] = elem.getValue();
            elem = elem.getNext();
            k++;
        }
        return arr;
    }

    public static <T extends Comparable> void sort(T[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            T elem1 = arr[i];
            for (int j = 0; j < arr.length; j++) {
                T elem2 = arr[j];
                if (elem1.compareTo(elem2) < 0){
                    T temp = elem1;
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static <T extends Comparable> boolean isSorted(T[] arr){
        T elem = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (elem.compareTo(arr[i]) > 0){
                return false;
            }
            elem = arr[i];
        }
        return true;
    }

    public static <T extends Comparable> int binarySearch(T elem, T[] arr) throws Exception {
        if (!isSorted(arr)){
            throw new NotSortedArrayException("Массив не отсортиорован");
        } else {
            int low = 0;
            int high = arr.length;
            while (low <= high){
                int m = (low + high) / 2;
                if (arr[m].compareTo(elem) <= 0){
                    low = m;
                } else {
                    high = m;
                }
            }
            if (arr[low].equals(elem)){
                return low;
            }
            return -1;
        }
    }


}
