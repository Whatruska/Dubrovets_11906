package Semester_Works.Semester_1.List;

public class PolinomList {
    private PolinomListItem head;
    private int size;

    public PolinomList(PolinomListItem head) {
        this.head = head;
        size++;
    }

    public PolinomList(){}

    public PolinomList(PolinomListItem[] arr){
        PolinomListItem last = head;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null) {
                if (i == 0){
                    head = arr[i];
                } else {
                    last.setNext(arr[i]);
                    last = last.getNext();
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
    public void add(PolinomListItem item){
        item = item.copy();
        PolinomListItem curr = head;
        PolinomListItem prev = head;

        if (size == 0){
            head = item;
        } else {
            while (item.compareTo(curr) < 0){
                if (curr == head){
                    curr = curr.getNext();
                } else {
                    curr = curr.getNext();
                    prev = prev.getNext();
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

    public void add(int coef, int deg1, int deg2, int deg3){
        add(new PolinomListItem(coef, deg1, deg2, deg3));
    }

    //T = O(N)
    public void delete(PolinomListItem item){
        PolinomListItem curr = head;
        PolinomListItem prev = head;

        if (size > 0){
            while (item.compareTo(curr) < 0){
                if (curr == head){
                    curr = curr.getNext();
                } else {
                    curr = curr.getNext();
                    prev = prev.getNext();
                }
            }
            if (curr == head){
                head = head.getNext();
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

    public void delete(int deg1, int deg2, int deg3){
        delete(new PolinomListItem(0, deg1, deg2, deg3));
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
