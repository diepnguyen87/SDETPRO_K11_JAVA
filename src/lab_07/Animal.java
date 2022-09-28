package lab_07;

import java.security.SecureRandom;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int speed() {
        int randomSpeed = new SecureRandom().nextInt(50);
        return randomSpeed;
    }
}
