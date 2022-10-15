package lab_11;

import java.util.Comparator;

public class SortedAnimal implements Comparator<lab_11.Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o2.getSpeed() - o1.getSpeed();
    }
}
