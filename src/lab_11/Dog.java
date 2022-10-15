package lab_11;

import java.security.SecureRandom;

public class Dog extends Animal implements AnimalBehavior {

    private static final int DOG_MAX_SPEED = 35;
    public Dog() {
        speed = new SecureRandom().nextInt(DOG_MAX_SPEED);
        isMove = true;
    }

    @Override
    public void move(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
    }

    @Override
    public void fly(int upperBound) {
        System.out.println("can not fly");
    }

    @Override
    public boolean isFly() {
        return false;
    }

    @Override
    public boolean isMove() {
        return true;
    }
}
