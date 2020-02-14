package SecondSem.Informatics.Lesson_1;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String string;
    private long firstNum;
    private long secondNum;
    private Operation operation;
    private int index;

    public Parser(String string) throws InputMismatchException, WrongOperationException, TooLongArgumentException {
        this.string = string;
        checkFormat();
        index = findOperationIndex();
        firstNum = parseFirstNum();
        secondNum = parseSecondNum();
        operation = parseOperation();
    }

    public long getFirstNum() {
        return firstNum;
    }

    public long getSecondNum() {
        return secondNum;
    }

    public Operation getOperation() {
        return operation;
    }

    private int findOperationIndex() throws InputMismatchException{
        char[] ops = new char[]{'+', '-', '*', '/'};
        int max = -1;
        for (char ch : ops){
            int index = string.lastIndexOf(ch);
            if (index > max){
                max = index;
            }
        }
        if (max == -1){
            throw new InputMismatchException();
        } else {
            return max;
        }
    }

    private int countMinus(){
        int count = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == '-'){
                count++;
            }
        }
        return count;
    }

    public long parseFirstNum(){
        if (countMinus() > 1 || string.charAt(0) == '-'){
            return -parseNums(1,index);
        } else {
            return parseNums(0,index);
        }
    }

    public long parseSecondNum(){
        return parseNums(index + 1, string.length());
    }

    private long parseNums(int start, int end){
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++){
            builder.append(string.charAt(i));
        }
        return Long.parseLong(builder.toString().trim());
    }

    public Operation parseOperation(){
        char ch = string.charAt(index);
        switch (ch){
            case '+' : return Operation.PLUS;
            case '-' : return Operation.MINUS;
            case '/' : return Operation.DIVIDE;
            case '*' : return Operation.MULTIPLY;
        }
        return Operation.MULTIPLY;
    }

    private void checkFormat() throws InputMismatchException, TooLongArgumentException, WrongOperationException {
        Matcher tooLongMatcher = Pattern.compile("[0-9]{16,}").matcher(string);
        Matcher wrongOperation = Pattern.compile("[^\\+\\-\\*\\/0-9]").matcher(string);
        if (tooLongMatcher.find()){
            throw new TooLongArgumentException();
        }
        if (wrongOperation.find()){
            throw new WrongOperationException();
        }
        if (!string.matches("^\\s*\\-?[0-9]{0,15}\\s*[\\+\\-\\*\\/]\\s*[0-9]{0,15}\\s*$")) {
            throw new InputMismatchException();
        }
    }

    public static int getLength(long a){
        int count = 0;
        while (a > 0){
            count++;
            a /= 10;
        }
        return count;
    }
}
