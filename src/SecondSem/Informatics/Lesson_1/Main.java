package SecondSem.Informatics.Lesson_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = scanner.nextLine();
        try {
            System.out.println(Calculator.calculate(input));
        } catch (TooLongResultException e) {
            System.out.println("Слишком большое число");
        } catch (ArithmeticException e){
            System.out.println("Ошибка деления на 0");
        } catch (InputMismatchException e){
            System.out.println("Неверный формат ввода");
        } catch (WrongOperationException e) {
            System.out.println("Неверная операция");
        } catch (TooLongArgumentException e) {
            System.out.println("Слишком большой аргумент (больше 16 символов)");
        }
    }
}
