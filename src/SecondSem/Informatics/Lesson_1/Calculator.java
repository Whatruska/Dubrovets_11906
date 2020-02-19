package SecondSem.Informatics.Lesson_1;

import java.util.InputMismatchException;

public class Calculator {
    public static long calculate(String input) throws ArithmeticException, TooLongResultException, InputMismatchException, WrongOperationException, TooLongArgumentException {
        Parser parser = new Parser(input);
        long a = parser.getFirstNum();
        Operation operation = parser.getOperation();
        long b = parser.getSecondNum();

        switch (operation){
            case PLUS:{
                if (a > 0){
                    Checker.checkBigSum(a,b);
                } else {
                    Checker.checkBigSub(b,a);
                }
                return (a + b);
            }

            case MINUS:{
                Checker.checkBigSub(a,b);
                return (a - b);
            }

            case DIVIDE:{
                Checker.checkDivide(b);
                return (a / b);
            }

            case MULTIPLY:{
                Checker.checkBigMultiply(a,b);
                return (a * b);
            }

            default:
                return -1;
        }
    }
}
