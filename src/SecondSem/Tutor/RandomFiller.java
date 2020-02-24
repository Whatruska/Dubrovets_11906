package SecondSem.Tutor;

import java.util.Random;

public class RandomFiller {
    public static AnimalList getRandomList(){
        AnimalList list = new AnimalList(new AnimalListElement(new Cow(32)));
        Random random = new Random();
        while (list.size() < 100){
            int randomInt = random.nextInt(30);
            if (randomInt <= 10){
                list.push(new Cow(randomInt));
            } else if (randomInt <= 20){
                list.push(new Horse(randomInt));
            } else {
                list.push(new Chicken(randomInt));
            }
        }
        return list;
    }
}
