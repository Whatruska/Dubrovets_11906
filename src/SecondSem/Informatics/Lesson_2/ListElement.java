package SecondSem.Informatics.Lesson_2;

public class ListElement<T extends Number> {
    private T value;
    private ListElement next;

    public ListElement(T value) {
        this.value = value;
        next = null;
    }

    public T getValue() {
        return value;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Value : " + value;
    }
}
