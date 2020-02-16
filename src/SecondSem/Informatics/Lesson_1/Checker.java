package SecondSem.Informatics.Lesson_1;

public class Checker {
    public static void checkBigSum(long firstNum, long secondNum) throws TooLongResultException {
        long max = Long.MAX_VALUE;
        if (max - firstNum < secondNum){
            throw new TooLongResultException();
        }
    }

    public static void checkBigMultiply(long firstNum, long secondNum) throws TooLongResultException {
        long max = Long.MAX_VALUE;
        if (max / firstNum < secondNum){
            throw new TooLongResultException();
        }
    }

    public static void checkDivide(long secondNum) throws ArithmeticException{
        if (secondNum == 0){
            throw new ArithmeticException();
        }
    }

    public static void checkBigSub(long firstNum, long secondNum) throws TooLongResultException {
        long max = Long.MIN_VALUE;
        if (max - firstNum > secondNum){
            throw new TooLongResultException();
        }
    }
}
