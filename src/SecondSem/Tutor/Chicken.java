package SecondSem.Tutor;

public class Chicken extends Animal {
    public Chicken(int mass) {
        this.mass = mass;
        legCount = 2;
    }

    public int getEggs(){
        return 4 * mass;
    }

    @Override
    public String toString() {
        return "Я - курицца, даю " + getEggs() + " яиц в день";
    }
}
