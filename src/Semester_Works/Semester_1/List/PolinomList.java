package Semester_Works.Semester_1.List;

public class PolinomList<T extends PolinomListItem> {
    private T head;
    private int size;

    public PolinomList(T head) {
        this.head = head;
        size++;
    }

    public PolinomList(){}

    public PolinomList(T[] arr){
        T last = head;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null) {
                if (i == 0){
                    head = arr[i];
                    last = head;
                } else {
                    last.setNext(arr[i]);
                    last = (T)last.getNext();
                }
                size++;
            }
        }
    }

    public PolinomListItem getHead() {
        return head;
    }

    public int size(){
        return size;
    }

    //T = O(N)
    public void add(T item){
        if (item != null){
            item = (T)item.copy();
            T curr = head;
            T prev = head;
            if (size == 0){
                head = item;
            } else {
                while (item.compareTo(curr) < 0){
                    if (curr == head){
                        curr = (T)curr.getNext();
                    } else {
                        curr = (T)curr.getNext();
                        prev = (T)prev.getNext();
                    }
                }
                if (item.compareTo(curr) == 0){
                    curr.setCoef(item.getCoef());
                    size--;
                } else {
                    if (curr == head){
                        head = item;
                        item.setNext(curr);
                    } else {
                        item.setNext(curr);
                        prev.setNext(item);
                    }
                }
            }

            size++;
        }
    }

    public void add(int coef, int deg1, int deg2, int deg3){
        add((T)new PolinomListItem(coef, deg1, deg2, deg3));
    }

    //T = O(N)
    public void delete(T item){
        T curr = head;
        T prev = head;

        if(item != null){
            if (size > 0){
                while (item.compareTo(curr) < 0){
                    if (curr == head){
                        curr = (T)curr.getNext();
                    } else {
                        curr = (T)curr.getNext();
                        prev = (T)prev.getNext();
                    }
                }
                if (curr == head){
                    head = (T)head.getNext();
                } else {
                    if (curr != null && curr.compareTo(item) == 0){
                        prev.setNext(curr.getNext());
                        curr.setNext(null);
                    } else {
                        size++;
                    }
                }
                size--;
            }
        }
    }

    public void delete(int deg1, int deg2, int deg3){
        delete((T)new PolinomListItem(0, deg1, deg2, deg3));
    }

    @Override
    public String toString() {
        String result = "";
        PolinomListItem item = head;
        for (int i = 0; i < size; i++){
            if (i == 0){
                if (item.getCoef() < 0){
                    result += "-";
                }
                result += item;
            } else  {
                int coef = item.getCoef();
                if (coef < 0){
                    result += " - ";
                } else {
                    result += " + ";
                }
                result += item;
            }
            item = item.getNext();
        }
        return result;
    }

    @Override
    //T = O(N)
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolinomList obj = (PolinomList) o;
        int size = obj.size;
        if (head == null && obj.getHead() == null){
            return true;
        } else if ((head == null && obj.getHead() != null) || (head != null && obj.getHead() == null) ){
            return false;
        } else {
            if (size != this.size || !head.equals(obj.getHead())) return false;
            PolinomListItem thisItem = head;
            PolinomListItem item = obj.getHead();
            for (int i = 0; i < size; i++){
                if (!item.equals(thisItem)){
                    return false;
                }
                thisItem = thisItem.getNext();
                item = item.getNext();
            }
        }
        return true;
    }
}
