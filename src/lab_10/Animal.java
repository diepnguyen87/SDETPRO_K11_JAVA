package lab_10;

import java.security.SecureRandom;

public abstract class Animal {

    protected String name;
    protected int speed;

    public Animal() {
    }

    public Animal(int speed) {
        this.speed = speed;
    }

    public Animal(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract Animal setSpeed(int speed);

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
