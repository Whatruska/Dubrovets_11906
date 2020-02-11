package FirstSem.Lesson_14;

public class Cashier {
    private int money;

    public Cashier(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Money : " + money;
    }
}
