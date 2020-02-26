package Tutor;

public class AnimalList<T extends Animal> {
    AnimalListElement<T> head;

    public AnimalList(AnimalListElement<T> head) {
        this.head = head;
    }

    public AnimalList() {
        this.head = null;
    }

    public AnimalListElement getHead(){
        return head;
    }

    public int size(){
        AnimalListElement<T> element = head;
        int count = 0;
        while (element != null){
            element = element.getNext();
            count++;
        }
        return count;
    }

    public void push(AnimalListElement<T> element){
        AnimalListElement<T> elem = head;
        while (elem.getNext() != null){
            elem = elem.getNext();
        }
        elem.setNext(element);
    }

    public void push(T animal){
        push(new AnimalListElement<>(animal));
    }
}
