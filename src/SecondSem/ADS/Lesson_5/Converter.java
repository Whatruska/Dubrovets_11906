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

    public static <T extends Comparable> T[] sort(T[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            T elem1 = arr[i];
            for (int j = 0; j < arr.length; j++) {
                T elem2 = arr[j];
                if (elem1.compareTo(elem2) > 0){
                    T temp = elem1;
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
