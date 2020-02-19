package SecondSem.Informatics.Lesson_2;

public class Main {

    public static void main(String[] args) {
        List<Double> list = new List<>(4.0);
        list.push(5.0);
        list.push(6.0);
        list.push(7.0);
        list.add(41.0, 0);
        list.deleteNextElem(1);

        List<Integer> list2 = new List<>(123);
        list2.push(43);

        list.deleteHead();

        list.joint(list2);

        list.printList();

    }

}
