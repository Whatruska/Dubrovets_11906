package SecondSem.ADS.Lesson_2;

import SecondSem.Informatics.Lesson_2.List;
import SecondSem.Informatics.Lesson_2.ListElement;

public class Set<T> {
    protected List<T> list;

    public Set() {
        list = new List<>();
    }

    //T = O(n)
    public void add(T value) {
        if (!contains(value)) {
            list.push(value);
        }
    }

    //T = O(n)
    public boolean contains(T value) {
        return contains(new ListElement<>(value));
    }

    //T = O(n)
    private boolean contains(ListElement<T> elem) {
        ListElement<T> curr = list.getHead();
        while (curr != null) {
            if (curr.getValue() == elem.getValue()) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public int size() {
        return list.size();
    }

    //T = O(n)
    public void printSet(){
        System.out.print("{");
        ListElement<T> element = list.getHead();
        while (element != null){
            System.out.print(element.getValue().toString() + (element.getNext() != null ? ", " : ""));
            element = element.getNext();
        }
        System.out.println("}");
    }
}