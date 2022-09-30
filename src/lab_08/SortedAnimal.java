package lab_08;

import java.util.Comparator;

public class SortedAnimal implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o2.getSpeed() - o1.getSpeed();
    }
}
