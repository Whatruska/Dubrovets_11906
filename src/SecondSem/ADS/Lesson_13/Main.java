package SecondSem.ADS.Lesson_13;

public class Main {
    public static void main(String[] args) {
        Node<Integer> leftTree = new Node<>(5);
        leftTree.setLeftChild(new Node<>(3));
        leftTree.setRightChild(new Node<>(7));
        Node<Integer> root = new Node<>(10);
        Node<Integer> rightTree = new Node<>(15);
        rightTree.setLeftChild(new Node<>(12));
        rightTree.setRightChild(new Node<>(20));
        root.setLeftChild(leftTree);
        root.setRightChild(rightTree);

        String print = printTree(root);
        System.out.println(print);
    }

    public static Node<Integer> formTreeFromPrint(String print){
        String str = "";
        Node<Integer> node = null;
        int childCount = 0;
        for (int i = 1; i < print.length(); i++) {
            char ch = print.charAt(i);
            if (ch != ',' && ch != 'N') {
                str += ch;
            } else if (ch == 'N'){
                if (childCount == 0){
                    node.setLeftChild(null);

                } else if (childCount == 1){
                    node.setRightChild(null);
                }
                childCount++;
            } else {
                node = new Node<>(Integer.parseInt(str));
                node.setLeftChild(formTreeFromPrint(print.substring(i + 2)));
                return node;
            }
        }
        return node;
    }

    public static String printTree (Node node){
        String res = "";
        res += "(";
        res += node.getValue() + ", ";
        if (node.getLeftChild() != null){
            res += printTree(node.getLeftChild()) + ", ";
        } else {
            res += "NULL, ";
        }
        if (node.getRightChild() != null){
            res += printTree(node.getRightChild());
        } else {
            res += "NULL";
        }
        res += ")";
        return res;
    }
}
