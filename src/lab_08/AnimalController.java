package lab_08;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnimalController {

    public static void main(String[] args) {
        AnimalController aniController = new AnimalController();

        Animal tiger = new Tiger();
        Animal horse = new Horse();
        Animal dog = new Dog();
        List<Animal> animalList = Arrays.asList(tiger, horse, dog);
        animalList.forEach(k -> System.out.println(k.getClass().getSimpleName() + "-" + k.getSpeed()));

        Animal winner = aniController.getTheWinnerBySpeed_Way4(animalList);
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
        Animal winner = animalList.get(0);

        return winner;
    }

    private Animal getTheWinnerBySpeed_Way3(List<Animal> animalList) {
        animalList.sort(Comparator.comparing(o -> o.getSpeed()));
        return animalList.get(animalList.size() - 1);
    }

    private Animal getTheWinnerBySpeed_Way4(List<Animal> animalList) {
        List<Animal> sortedList = animalList.stream().sorted(((o1, o2) -> o1.getSpeed().
                        compareTo(o2.getSpeed()))).
                collect(Collectors.toList());
        return sortedList.get(sortedList.size()-1);
    }
}
