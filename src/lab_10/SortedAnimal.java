package lab_10;

import java.util.Comparator;

public class SortedAnimal implements Comparator<lab_10.Animal> {

    @Override
    public int compare(lab_10.Animal o1, Animal o2) {
        return o2.getSpeed() - o1.getSpeed();
    }
}
