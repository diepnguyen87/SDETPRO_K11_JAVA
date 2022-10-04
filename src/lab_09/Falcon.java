package lab_09;

import java.security.SecureRandom;

public class Falcon extends Animal {

    private static final int FALCON_MAX_SPEED = 60;
    public Falcon() {
        super(new SecureRandom().nextInt(FALCON_MAX_SPEED));
    }
}
