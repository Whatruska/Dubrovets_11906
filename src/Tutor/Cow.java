package Tutor;

public class Cow extends Animal {
    public Cow(int mass) {
        this.mass = mass;
        legCount = 4;
    }

    public int getMilk(){
        return legCount * mass;
    }

    @Override
    public String toString() {
        return "Я - корова, даю " + getMilk() + " литров молока в день";
    }
}
