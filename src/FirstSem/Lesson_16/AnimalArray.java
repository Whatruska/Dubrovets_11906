package FirstSem.Lesson_16;

import FirstSem.Lesson_16.Interfaces.Animal;

public class AnimalArray {
    private Animal[] animals;
    private int freeIndex = 0;

    public AnimalArray(int length) {
        this.animals = new Animal[length];
    }

    public int size(){
        return animals.length;
    }

    public void add(Animal animal){
        if (freeIndex >= animals.length){
            increaseCapacity();
        }
        animals[freeIndex] = animal;
        freeIndex++;
    }

    public void increaseCapacity(){
        Animal[] result = new Animal[animals.length + 1];
        for (int i = 0; i < animals.length; i++){
            result[i] = animals[i];
        }
        animals = result;
    }

    public Animal get(int index){
        if (isValidIndex(index)){
            return animals[index];
        }
        return null;
    }

    public void remove(int index){
        if (isValidIndex(index)){
            shift(index);
        }
    }

    public void remove(Animal animal){
        for (int i = 0; i < animals.length; i++){
            if (animals[i].equals(animal)){
                shift(i);
            }
        }
    }

    private void shift(int index){
        animals[index] = null;
        for (int i = index + 1; i < animals.length; i++){
            animals[i - 1] = animals[i];
        }
        animals[animals.length - 1] = null;
    }

    private boolean isValidIndex(int index){
        return index > -1 && index < animals.length;
    }
}
