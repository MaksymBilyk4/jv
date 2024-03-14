package test.testAbstract.model;

public abstract class Fish extends Animal {

    public Fish(String name) {
        super(name);

    }

    abstract void swim();

    public void sleep() {
        System.out.println("How fish are sleep?!");
    }

}
