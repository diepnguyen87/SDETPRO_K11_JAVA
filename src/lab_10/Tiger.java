package lab_10;

import java.security.SecureRandom;

public class Tiger extends Animal {

    private static final int TIGER_MAX_SPEED = 80;

    public Tiger() {}

    @Override
    public Tiger setSpeed(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
        return this;
    }

}
