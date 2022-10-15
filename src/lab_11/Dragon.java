package lab_11;

import java.security.SecureRandom;

public class Dragon extends Animal implements AnimalBehavior {

    private static final int DRAGON_MAX_SPEED = 35;
    public Dragon() {
        speed = new SecureRandom().nextInt(DRAGON_MAX_SPEED);
        isFly = true;
    }

    @Override
    public void fly(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
    }

    @Override
    public void move(int upperBound) {
        System.out.println("Can not move");
    }

    @Override
    public boolean isMove() {
        return false;
    }

    @Override
    public boolean isFly() {
        return true;
    }
}
