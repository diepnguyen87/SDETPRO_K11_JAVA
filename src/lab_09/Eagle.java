package lab_09;

import java.security.SecureRandom;

public class Eagle extends Animal{

    private static final int EAGLE_MAX_SPEED = 60;
    public Eagle() {
        super(new SecureRandom().nextInt(EAGLE_MAX_SPEED));
    }
}
