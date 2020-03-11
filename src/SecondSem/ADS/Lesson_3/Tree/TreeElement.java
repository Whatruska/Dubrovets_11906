package SecondSem.ADS.Lesson_3.Tree;

public class TreeElement<T extends Comparable> {
    private T value;
    private TreeElement<T> rightChild;
    private TreeElement<T> leftChild;

    public TreeElement(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeElement<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeElement<T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeElement<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeElement<T> leftChild) {
        this.leftChild = leftChild;
    }
}
