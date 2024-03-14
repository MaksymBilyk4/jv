package test.testAbstract.model;

public class Mechenosec extends Fish{

    public Mechenosec(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println("Eating fish feed");
    }

    @Override
    void swim() {
        System.out.println("Mechenosec swims fast!");
    }
}
