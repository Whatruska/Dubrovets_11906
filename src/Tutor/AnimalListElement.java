package Tutor;

public class AnimalListElement<T extends Animal> {
    private T animal;
    private AnimalListElement<T> next;

    public AnimalListElement(T animal, AnimalListElement next) {
        this.animal = animal;
        this.next = next;
    }

    public AnimalListElement(T animal){
        this(animal, null);
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public AnimalListElement getNext() {
        return next;
    }

    public void setNext(AnimalListElement next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return animal.toString();
    }
}
