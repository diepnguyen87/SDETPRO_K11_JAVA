package lab_10;

import java.security.SecureRandom;

public class Horse extends Animal {

    private static final int HORSE_MAX_SPEED = 70;

    public Horse() {}

    @Override
    public Horse setSpeed(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
        return this;
    }
}
