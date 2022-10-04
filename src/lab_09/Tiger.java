package lab_09;

import java.security.SecureRandom;

public class Tiger extends Animal{

    private static final int TIGER_MAX_SPEED = 60;
    public Tiger() {
        super(new SecureRandom().nextInt(TIGER_MAX_SPEED));
    }
}
