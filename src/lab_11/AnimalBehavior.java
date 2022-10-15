package lab_11;

public interface AnimalBehavior extends MoveBehavior, FlyBehavior {

    boolean isMove();
    boolean isFly();
}
