package lab_12;

public class Mute implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("mute mute");
    }
}
