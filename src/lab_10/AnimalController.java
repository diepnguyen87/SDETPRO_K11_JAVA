package lab_10;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lab_10.Animal;

public class AnimalController {

    public static void main(String[] args) {
        AnimalController aniController = new AnimalController();

        Animal tiger = new Tiger().setSpeed(55);
        Animal horse = new Horse().setSpeed(50);
        Animal dog = new Dog();

        List<Animal> animalList = Arrays.asList(tiger, horse, dog);
        animalList.forEach(k -> System.out.println(k.getClass().getSimpleName() + "-" + k.getSpeed()));

        lab_10.Animal winner = aniController.getTheWinnerBySpeed_Way1(animalList);
        int winnerSpeed = winner.getSpeed();
        String winnerName = winner.getClass().getSimpleName();

        System.out.printf("The winner is: %s - with speed: %d", winnerName, winnerSpeed);
    }

    private Animal getTheWinnerBySpeed_Way1(List<Animal> animalList) {

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

    private Animal getTheWinnerBySpeed_Way2(List<Animal> animalList) {
        Collections.sort(animalList, new SortedAnimal());
        lab_10.Animal winner = animalList.get(0);

        return winner;
    }

    private Animal getTheWinnerBySpeed_Way3(List<Animal> animalList) {
        animalList.sort(Comparator.comparing(o -> o.getSpeed()));
        return animalList.get(animalList.size() - 1);
    }
}
