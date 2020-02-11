package SecondSem.Lesson_1;

import java.util.InputMismatchException;

public class Calculator {
    public static long calculate(String input){
        try {
            Parser parser = new Parser(input);
            long a = parser.getFirstNum();
            Operation operation = parser.getOperation();
            long b = parser.getSecondNum();

            switch (operation){
                case PLUS:{
                    parser.checkBigSum();
                    return (a + b);
                }

                case MINUS:{
                    return (a - b);
                }

                case DIVIDE:{
                    parser.checkDivide();
                    return (a / b);
                }

                case MULTIPLY:{
                    parser.checkBigMultiply();
                    return (a * b);
                }
            }
        } catch (ArithmeticException e){
            System.out.println("Бесконечность");
        } catch (TooLongException e){
            System.out.println("Слишком большое число в результате");
        } catch (InputMismatchException e){
            System.out.println("Неверный формат");
        }

        return -1;
    }
}
