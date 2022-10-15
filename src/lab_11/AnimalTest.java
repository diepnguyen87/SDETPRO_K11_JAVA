package lab_11;

import java.util.*;

public class AnimalTest {

    public static void main(String[] args) {
        Animal winner = new Animal();
        AnimalTest animalTest = new AnimalTest();

        Dog dog = new Dog();
        dog.move(25);

        Eagle eagle = new Eagle();
        eagle.move(79);
        eagle.fly(88);

        Dragon dragon = new Dragon();
        dragon.fly(99);

        List<AnimalBehavior> animalList = Arrays.asList(dog, dragon, eagle);
        List<Animal> movableAnimalList = animalTest.getMovableAnimalList(animalList);
        movableAnimalList.forEach(k -> System.out.println(k.getClass().getSimpleName() + "-" + k.getSpeed()));

        if (animalList.isEmpty()) {
            System.out.println("No animal join the racing");
            return;
        } else if (animalList.size() == 1 && animalList.get(0).isMove()) {
            winner = (Animal) animalList.get(0);
            animalTest.showAnimalWinner(winner);
            return;
        } else if (animalList.size() == 1 && animalList.get(0).isFly()) {
            System.out.println("No animal with movable in the racing");
            return;
        }

        winner = animalTest.getWinnerBySpeed(animalList);
    }

    public Animal getWinnerBySpeed(List<AnimalBehavior> animalList) {

        List<Animal> moveableAnimalList = getMovableAnimalList(animalList);

        for (AnimalBehavior animal : animalList) {
            if (animal instanceof MoveBehavior) {
                moveableAnimalList.add((Animal) animal);
            }
        }

        Collections.sort(moveableAnimalList, new SortedAnimal());
        lab_11.Animal winner = moveableAnimalList.get(0);
        return winner;
    }

    private List<Animal> getMovableAnimalList(List<AnimalBehavior> animalList) {

        List<Animal> moveableAnimalList = new ArrayList<>();
        for (AnimalBehavior animal : animalList) {
            if (animal.isMove()) {
                moveableAnimalList.add((Animal) animal);
            }
        }
        return moveableAnimalList;
    }

    private void showAnimalWinner(Animal winner) {
        int winnerSpeed = winner.getSpeed();
        String winnerName = winner.getClass().getSimpleName();

        System.out.printf("The winner is: %s - with speed: %d", winnerName, winnerSpeed);
    }
}
