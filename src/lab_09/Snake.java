package lab_09;

import java.security.SecureRandom;

public class Snake extends Animal {

    private static final int SNAKE_MAX_SPEED = 60;
    public Snake() {
        super(new SecureRandom().nextInt(SNAKE_MAX_SPEED));
    }
}
