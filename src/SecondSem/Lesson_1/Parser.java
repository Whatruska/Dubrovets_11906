package SecondSem.Lesson_1;

import java.util.InputMismatchException;

public class Parser {
    private String string;
    private long firstNum;
    private long secondNum;
    private Operation operation;
    private int index;

    public Parser(String string) throws InputMismatchException{
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

    public void checkBigMultiply() throws TooLongException{
        int l1 = getLength(getFirstNum());
        int l2 = getLength(getSecondNum());
        if (l1 + l2 > 16) {
            throw new TooLongException();
        }
    }

    public void checkBigSum() throws TooLongException{
        if (getLength(getFirstNum() + getSecondNum()) > 16) {
            throw new TooLongException();
        }
    }

    public void checkDivide() throws ArithmeticException{
        if (secondNum == 0){
            throw new ArithmeticException();
        }
    }

    private void checkFormat() throws InputMismatchException {
        //TODO: Check format
        if (!string.matches("^\\-?[0-9]{0,15}\\s+[\\+\\-\\*\\/]\\s+[0-9]{0,15}$")) {
            throw new InputMismatchException();
        }
    }

    public int getLength(long a){
        int count = 0;
        while (a > 0){
            count++;
            a /= 10;
        }
        return count;
    }
}
