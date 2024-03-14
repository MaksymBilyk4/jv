package test.testAbstract.model;

public class Pingvin extends Bird {

    public Pingvin(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println("Pingvin eats");
    }

    @Override
    void sleep() {
        System.out.println("Pingvin sleeps");
    }

    @Override
    void fly() {
        System.out.println("I can't fly...");
    }

    @Override
    public void speak() {
        System.out.println("I can't sing...");
    }
}
