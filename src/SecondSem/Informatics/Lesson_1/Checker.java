package SecondSem.Informatics.Lesson_1;

public class Checker {
    public static void checkBigSum(long firstNum, long secondNunm) throws TooLongResultException {
        if (Parser.getLength(firstNum + secondNunm) > 16) {
            throw new TooLongResultException();
        }
    }

    public static void checkBigMultiply(long firstNum, long secondNum) throws TooLongResultException {
        if (Parser.getLength(firstNum) + Parser.getLength(secondNum) > 16) {
            throw new TooLongResultException();
        }
    }

    public static void checkDivide(long secondNum) throws ArithmeticException{
        if (secondNum == 0){
            throw new ArithmeticException();
        }
    }

    public static void checkBigSub(long firstNum, long secondNunm) throws TooLongResultException {
        if (Parser.getLength(firstNum - secondNunm) > 16) {
            throw new TooLongResultException();
        }
    }
}
