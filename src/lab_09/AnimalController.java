package lab_09;

import java.util.*;

public class AnimalController {

    public static void main(String[] args) {
        AnimalController aniController = new AnimalController();

        Animal tiger = new Animal.Builder().withFlyable(false).build();
        Animal snake = new Animal.Builder().withSpeed(50).withFlyable(false).build();
        Animal falcon = new Animal.Builder().withSpeed(22).withFlyable(true).build();
        Animal eagle = new Animal.Builder().withSpeed(58).withFlyable(true).build();

        List<Animal> animalList = Arrays.asList(tiger, snake, falcon, eagle);
        animalList.forEach(k -> System.out.println(k.getClass().getSimpleName() + "-" + k.getSpeed()));

        List<Animal> notFlyableAnimalList = aniController.getAnimalsNotFlyable(animalList);
        Animal winner = aniController.getTheWinnerBySpeed(notFlyableAnimalList);

        int winnerSpeed = winner.getSpeed();
        String winnerName = winner.getClass().getSimpleName();

        System.out.printf("The w*/inner is: %s - with speed: %d", winnerName, winnerSpeed);
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
