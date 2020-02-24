package SecondSem.Tutor;

public class Horse extends Animal {
    public Horse(int mass) {
        this.mass = mass;
        legCount = 4;
    }

    public void eatApples(){
        System.out.println("Ем яблоки");
    }

    public void move(){
        System.out.println("Бегу");
    }

    @Override
    public String toString() {
        return "Я - лошадь, умею двигаться ";
    }
}
