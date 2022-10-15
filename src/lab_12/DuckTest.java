package lab_12;

public class DuckTest {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        BabyDuck babyDuck = new BabyDuck();

        DuckTest duckTest = new DuckTest();
        babyDuck.setQuackBehavior(new Quack());
        duckTest.performQuack(mallardDuck);
        duckTest.performQuack(babyDuck);
    }

    public void performQuack(Duck duck){
        duck.performQuack();
    }
}
