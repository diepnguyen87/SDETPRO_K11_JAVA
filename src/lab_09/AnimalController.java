package lab_09;

import java.util.*;

public class AnimalController {

    public static void main(String[] args) {
        AnimalController aniController = new AnimalController();

        Animal tiger = new Animal.Builder().setName("Tiger").withSpeed(80).withFlyable(false).build();
        Animal snake = new Animal.Builder().setName("Snake").withSpeed(50).withFlyable(false).build();
        Animal falcon = new Animal.Builder().setName("Falcon").withSpeed(22).withFlyable(true).build();
        Animal eagle = new Animal.Builder().setName("Eagle").withSpeed(68).withFlyable(true).build();

        List<Animal> animalList = Arrays.asList(tiger, snake, falcon, eagle);
        animalList.forEach(k -> System.out.println(k.getName() + "-" + k.getSpeed()));

        List<Animal> notFlyableAnimalList = aniController.getAnimalsNotFlyable(animalList);
        Animal winner = aniController.getTheWinnerBySpeed(notFlyableAnimalList);

        int winnerSpeed = winner.getSpeed();
        String winnerName = winner.getName();
        System.out.printf("The winner with flyable is: %s - with speed: %d", winnerName, winnerSpeed);
    }

    private List<Animal> getAnimalsNotFlyable(List<Animal> animalList) {
        List<Animal> notFlyableAnimal = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.isFlyable() == false) {
                notFlyableAnimal.add(animal);
            }
        }
        return notFlyableAnimal;
    }

    private Animal getTheWinnerBySpeed(List<Animal> animalList) {

        int maxSpeed = 0;
        int winnerIndexBySpeed = 0;

        for (int i = 0; i < animalList.size(); i++) {

            int animalSpeed = animalList.get(i).getSpeed();
            if (animalSpeed > maxSpeed) {
                maxSpeed = animalSpeed;
                winnerIndexBySpeed = i;
            }
        }
        return animalList.get(winnerIndexBySpeed);
    }
}
