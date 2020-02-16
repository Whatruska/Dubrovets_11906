package SecondSem.Informatics.Lesson_1;

public class WrongOperationException extends Exception {
    WrongOperationException(int index){
        printStackTrace();
        System.out.println("Индекс операции : " + index);
    }
}
