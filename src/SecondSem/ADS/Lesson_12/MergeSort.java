package SecondSem.ADS.Lesson_12;

import SecondSem.Informatics.Lesson_2.ListElement;

public class MergeSort {

    public static <T extends Comparable<T>> ListElement<T> MergeSortedList(ListElement<T> lst1, ListElement<T> lst2) {
        ListElement<T> result = null;

        // Base Cases
        if (lst1 == null)
            return (lst2);
        else if (lst2 == null)
            return (lst1);

        // recursively merging two lists
        if (lst1.getValue().compareTo(lst2.getValue()) <= 0) {
            result = lst1;
            ListElement<T> el = MergeSortedList(lst1.getNext(), lst2);
            result.setNext(el);
        }
        else {
            result = lst2;
            ListElement<T> el = MergeSortedList(lst1, lst2.getNext());
            result.setNext(el);
        }
        return result;
    }

    // Splitting two into halves.
// If the size of the list is odd, then extra element goes in the first list.
    public static <T extends Comparable<T>> ListElement<T>[] SplitList(ListElement<T> source, ListElement<T> front, ListElement<T> back) {
        ListElement<T> ptr1;
        ListElement<T> ptr2;
        ptr2 = source;
        ptr1 = source.getNext();

        // ptr1 is incrmented twice and ptr2 is icremented once.
        while (ptr1 != null) {
            ptr1 = ptr1.getNext();
            if (ptr1 != null) {
                ptr2 = ptr2.getNext();
                ptr1 = ptr1.getNext();
            }
        }

        // ptr2 is at the midpoint.
        front = source;
        back = ptr2.getNext();
        back.setNext(null);

        return new ListElement[]{front, back};
    }


    // Merge Sort
    public static <T extends Comparable<T>> ListElement<T> MergeSort(ListElement<T> thead) {
        ListElement<T> head = thead.getNext();
        ListElement<T> ptr1 = null;
        ListElement<T> ptr2 = null;

        // Base Case
        if ((head == null) || (head.getNext() == null)) {
            return null;
        }

        // Splitting list
        ListElement<T>[] arr = SplitList(head, ptr1, ptr2);
        ptr1 = arr[0];
        ptr2 = arr[1];

        // Recursively sorting two lists.
        ptr1 = MergeSort(ptr1);
        ptr2 = MergeSort(ptr2);

        // Sorted List.
        ListElement<T> el = MergeSortedList(ptr1, ptr2);
	    thead.setNext(el);

	    return thead;
    }



    // Printing List.
    public static <T extends Comparable<T>> void printList(ListElement<T> tnode) {
        while (tnode != null) {
            System.out.print(tnode.getValue() + " ");
            tnode = tnode.getNext();
        }
    }

    // Push function for inserting nodes in the list.
    public static <T extends Integer> ListElement<Integer> push(ListElement<Integer> thead, int new_data) {
        ListElement<Integer> new_node = new ListElement<>();
        new_node.setValue(new_data);
        new_node.setNext(thead);
        return new_node;
    }

    public static void main(String[] args) {
        // Empty list
        ListElement<Integer> res = null;
        ListElement<Integer> MyList = null;

        // List: 10->4->15->1->2->12->54
        MyList = push(MyList, 54);
        MyList = push(MyList, 12);
        MyList = push(MyList, 2);
        MyList = push(MyList, 1);
        MyList = push(MyList, 15);
        MyList = push(MyList, 4);
        MyList = push(MyList, 10);

        System.out.println("Unsorted");
        printList(MyList);
        System.out.println();

        MyList = MergeSort(MyList);

        System.out.println("Sorted Linked List: ");
        printList(MyList);
    }
}
