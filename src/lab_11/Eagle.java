package lab_11;

import java.security.SecureRandom;

public class Eagle extends Animal implements AnimalBehavior {

    private static final int EAGLE_MAX_SPEED = 85;
    public Eagle() {
        speed = new SecureRandom().nextInt(EAGLE_MAX_SPEED);
        isFly = true;
        isMove = true;
    }

    @Override
    public void move(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
    }

    @Override
    public void fly(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
    }

    @Override
    public boolean isMove() {
        return true;
    }

    @Override
    public boolean isFly() {
        return true;
    }
}
