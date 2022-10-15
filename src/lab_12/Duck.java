package lab_12;

public class Duck {

    protected QuackBehavior quackBehavior;

    protected void performQuack(){
        quackBehavior.quack();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
}
