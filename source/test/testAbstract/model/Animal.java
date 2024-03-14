package test.testAbstract.model;

public abstract class Animal {

    protected String name;


    public Animal (String name) {
        this.name = name;
    }

    abstract void eat();
    abstract void sleep();

}
