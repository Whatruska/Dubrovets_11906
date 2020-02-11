package FirstSem.Homework_1;

public class FirstTask {
    public static void main(String[] args) {
        int x = 5461977;
        System.out.println(x);

        int firstSign = x / 100;
        firstSign = firstSign % 10;

        int secondSign = x / 10000;
        secondSign = secondSign % 10;

        int change = firstSign * 100;
        x = x - change;
        change = firstSign * 10000;
        x = x + change;

        change = secondSign * 10000;
        x = x - change;
        change = secondSign * 100;
        x = x + change;

        System.out.println(x);
    }
}
