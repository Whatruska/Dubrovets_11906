package SecondSem.Informatics.Lesson_4;

import SecondSem.Informatics.Lesson_2.List;
import SecondSem.Informatics.Lesson_2.ListElement;

public class StudentList<T extends Student> extends List<T> {
    public StudentList(ListElement<T> head) {
        super(head);
    }

    public StudentList(T value){
        super(value);
    }

    public void doExcercise(int from, int to){
        ListElement<T> fromStud = get(from);
        ListElement<T> toStud = get(to);
        while (!fromStud.getValue().equals(toStud.getValue())){
            fromStud.getValue().doExcercise();
            fromStud = fromStud.getNext();
        }
    }

    public boolean checkFiloming(){
        ListElement<T> stud = getHead();
        while (stud != null){
            if (stud.getValue().getExcercises() == 0){
                return true;
            }
            stud = stud.getNext();
        }
        return false;
    }

    public boolean checkSuperStudent(){
        ListElement<T> stud = getHead();
        while (stud != null){
            if (stud.getValue().getExcercises() < 100){
                return false;
            }
            stud = stud.getNext();
        }
        return true;
    }
}
