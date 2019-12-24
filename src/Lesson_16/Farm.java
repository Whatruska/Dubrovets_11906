package Lesson_16;

import Lesson_16.Interfaces.*;

public class Farm {

    private AnimalArray animals;

    public Farm() {
        animals = new AnimalArray(0);
    }

    private boolean isWoolable(Animal animal){
        return animal instanceof Woolable;
    }

    private boolean isMoveable(Animal animal){
        return animal instanceof Moveable;
    }

    private boolean isMilkable(Animal animal){
        return animal instanceof Milkable;
    }

    public void addNewAnimal(Animal animal){
        animals.add(animal);
    }

    public void feedAll(int weight){
        for (int i = 0; i < animals.size(); i++){
            animals.get(i).eat(weight);
        }
    }

    public int getAllMilk(){
        int sum = 0;
        for (int i = 0; i < animals.size(); i++){
            Animal animal = animals.get(i);
            if (isMilkable(animal)){
                Milkable milkable = (Milkable) animal;
                sum += milkable.getMilk();
            }
        }
        return sum;
    }

    public int getAllWool(){
        int sum = 0;
        for (int i = 0; i < animals.size(); i++){
            Animal animal = animals.get(i);
            if (isWoolable(animal)){
                Woolable woolable = (Woolable) animal;
                sum += woolable.getWool();
            }
        }
        return sum;
    }

    public void move(int index, int weight){
        if (isValidIndex(index)){
            Animal animal = animals.get(index);
            if (isMoveable(animal)){
                Moveable moveable = (Moveable) animal;
                moveable.move(weight);
            }
        }
    }

    public int getMeat(int index){
        int res = 0;
        if (isValidIndex(index)){
            Animal animal = animals.get(index);
            res = animal.getMeat();
        }
        return res;
    }

    private boolean isValidIndex(int index){
        return index > -1 && index < animals.size();
    }
}
