package SecondSem.Informatics.Lesson_1;

public class TooLongArgumentException extends Exception {
    TooLongArgumentException(String str){
        printStackTrace();
        System.out.println(str);
    }
}
