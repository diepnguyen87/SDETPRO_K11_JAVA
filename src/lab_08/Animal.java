package lab_08;

import java.security.SecureRandom;

public class Animal {

    private Integer speed;

    public Animal() {
    }

    public Animal(int speed) {
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer setRandomSpeed(int upperBound) {
        speed = new SecureRandom().nextInt(upperBound);
        return speed;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " - speed = " + speed;
    }
}
