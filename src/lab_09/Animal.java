package lab_09;

import java.security.SecureRandom;

public class Animal {

    private String name;
    private int speed;
    private boolean flyable;

    protected Animal(Builder builder) {
        this.name = builder.name;
        this.speed = builder.speed;
        this.flyable = builder.flyable;
    }

    protected Animal(Integer speed) {
       this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isFlyable() {
        return flyable;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " - speed = " + speed;
    }

    public static class Builder {

        private String name;
        private int speed;
        private boolean flyable;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSpeed(int maxSpeed) {
            this.speed = new SecureRandom().nextInt(maxSpeed);;
            return this;
        }

        public Builder withFlyable(boolean flyable) {
            this.flyable = flyable;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}
