package Semester_Works.Semester_2;

public class Node<T extends Comparable> {
    private Node leftChild;
    private Node rightChild;
    private T value;
    private int height;

    public Node(T value) {
        this.value = value;
        height = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void sort(){
        if ((rightChild != null && value.compareTo(rightChild.getValue()) < 0) || ( leftChild != null && value.compareTo(leftChild.getValue()) < 0)){
            T rightVal = rightChild != null ? (T)rightChild.getValue() : null;
            T leftVal = leftChild != null ? (T)leftChild.getValue() : null;
            T temp;
            if(rightVal != null && rightVal.compareTo(leftVal) >= 0){
                temp = rightVal;
                rightChild.setValue(value);
                value = temp;
                rightChild.sort();
            } else if (leftVal != null){
                temp = leftVal;
                leftChild.setValue(value);
                value = temp;
                leftChild.sort();
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("value=").append(value);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}
