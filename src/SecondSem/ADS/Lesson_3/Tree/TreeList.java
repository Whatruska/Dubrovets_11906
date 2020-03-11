package SecondSem.ADS.Lesson_3.Tree;

public class TreeList<T extends Comparable> {
    TreeElement<T> root;
    private int size;

    public TreeList(TreeElement<T> root) {
        this.root = root;
    }

    public TreeList() {
    }

    public int getSize(){
        return size;
    }

    public TreeElement<T> getRoot() {
        return root;
    }

    public void push(T value){
        push(new TreeElement<>(value));
    }

    public void push(TreeElement<T> element){
        if (root == null){
            root = element;
        } else {
            TreeElement<T> parent = root;
            T value = element.getValue();
            while (shouldCheckLeft(value, parent) || shouldCheckRight(value, parent)){
                T parentValue = parent.getValue();
                if (isLess(value, parentValue)){
                    parent = parent.getLeftChild();
                } else {
                    parent = parent.getRightChild();
                }
            }
            T currVal = parent.getValue();
            if (isLess(value, currVal)){
                parent.setLeftChild(new TreeElement<>(value));
            } else {
                parent.setRightChild(new TreeElement<>(value));
            }
        }
        size++;
    }

    public TreeElement<T> get (T value){
        TreeElement<T> elem = root;
        if (root == null){
            return null;
        }
        while ((shouldCheckRight(value, elem) || shouldCheckLeft(value, elem)) && elem.getValue().compareTo(value) != 0){
            if (isLess(value, elem.getValue())){
                elem = elem.getLeftChild();
            } else {
                elem = elem.getRightChild();
            }
        }
        if (elem.getValue().compareTo(value) == 0){
            return elem;
        }
        return null;
    }

    public void remove(T value){
        if (size == 1){
            if (root.getValue().equals(value)){
                root = null;
                size = 0;
            }
        } else {
            TreeElement<T> elem = get(value);
            T higher = higher(value);
            elem.setValue(higher);
            size--;
        }
    }

    public T higher(T value){
        TreeElement<T> elem = root;
        TreeElement<T> parent = null;
        while ((shouldCheckRight(value, elem) || shouldCheckLeft(value, elem)) && elem.getValue().compareTo(value) != 0){
            if (isLess(value, elem.getValue())){
                parent = elem;
                elem = elem.getLeftChild();
            } else {
                parent = elem;
                elem = elem.getRightChild();
            }
        }
        T parentValue = parent.getValue();

        TreeElement<T> parent2 = elem;
        TreeElement<T> elem2 = elem;
        if (elem2.getRightChild() != null){
            elem2 = elem2.getLeftChild();
            while (elem2.getLeftChild() != null){
                parent2 = elem2;
                elem2 = elem2.getLeftChild();
            }
            T val = elem2.getValue();
            parent2.setLeftChild(null);
            return val;
        } else {
            parent.setValue(elem.getValue());
            parent.setLeftChild(elem.getLeftChild());
            elem.setLeftChild(null);
            return parentValue;
        }
    }

    public boolean isMoreOrEquals (T value1, T value2){
        return value1.compareTo(value2) != -1;
    }

    public boolean isLess (T value1, T value2){
        return !isMoreOrEquals(value1, value2);
    }

    public boolean shouldCheckLeft(T value, TreeElement<T> parent){
        return isLess(value, parent.getValue()) && parent.getLeftChild() != null;
    }

    public boolean shouldCheckRight(T value, TreeElement<T> parent){
        return isMoreOrEquals(value, parent.getValue()) && parent.getRightChild() != null;
    }
}
