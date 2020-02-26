package SecondSem.Informatics.Lesson_2;

public class List<T> {
   private ListElement<T> head;

    public List(ListElement<T> head) {
        this.head = head;
    }

    public List(T value){
        this.head = new ListElement<>(value);
    }

    public ListElement<T> getHead(){
        return head;
    }

    public int size(){
        ListElement<T> elem = head;
        int count = 0;
        while (elem != null){
            elem = elem.getNext();
            count++;
        }
        return count;
    }

    public ListElement<T> get(int index){
        if (index < size()){
            ListElement<T> elem = head;
            for (int i = 0; i < index; i++){
                elem = elem.getNext();
            }
            return elem;
        }
        return null;
    }

    public ListElement<T> findValue(T value){
        ListElement<T> elem = head;
        while (!elem.getValue().equals(value)){
            elem = elem.getNext();
        }
        return elem;
    }

    public void add(ListElement<T> elem, int index){
        ListElement<T> element = get(index);
        elem.setNext(element.getNext());
        element.setNext(elem);
    }

    public void add(T value, int index){
        add(new ListElement<>(value), index);
    }

    public void push(ListElement<T> element){
        add(element, size() - 1);
    }

    public void push(T value){
        push(new ListElement<>(value));
    }

    public void deleteNextElem(int index){
        if (index == -1){
            deleteHead();
        } else {
            ListElement<T> element = get(index);
            ListElement<T> del = element.getNext();
            ListElement<T> next = del.getNext();

            del.setNext(null);
            element.setNext(next);
        }
    }

    public void deleteHead(){
       ListElement<T> nextHead  = head.getNext();
       head.setNext(null);
       this.head = nextHead;
    }

    public void joint(List<T> list){
        get(size() - 1).setNext(list.getHead());
    }

    public void printList(){
        for (int i = 0; i < size(); i++){
            System.out.println(get(i));
        }
    }

    public void deleteSubList(int startInd, int finishInd){
        ListElement<T> element = get(startInd);
        ListElement<T> prev = get(finishInd - 1);
        ListElement<T> next = prev.getNext();
        prev.setNext(null);
        element.setNext(next);

//        int d = finishInd - startInd + 1;
//        ListElement<T> element = startInd > 0 ? get(startInd - 1) : head;
//        for (int i = 0; i < d; i++){
//            if (startInd == 0){
//                deleteHead();
//            } else {
//                deleteElement(element, element.getNext());
//            }
//        }
    }

    public void insertList(List<T> list, int pos){
        ListElement<T> element = get(pos);
        ListElement<T> next = element.getNext();
        element.setNext(list.getHead());
        list.get(list.size() - 1).setNext(next);
    }

    public List<T> findAllValues(T value){
        ListElement<T> element = head;
        List<T> result = new List<>(element.getValue());
        while (element != null){
            if (element.getValue().equals(value)){
                result.push(value);
            }
            element = element.getNext();
        }
        result.deleteHead();
        return result;
    }

    public List<Integer> findAllIndexesOfValues(T value){
        List<Integer> result = new List<>(-1);
        ListElement<T> elem = head;
        int count = 0;
        while (elem != null){
            T val = elem.getValue();
            if (val.equals(value)){
                result.push(count);
            }
            count++;
            elem = elem.getNext();
        }
        result.deleteHead();
        return result;
    }

}