package test.testAbstract.model;

import test.testAbstract.interfaces.Speakable;

public abstract class Bird extends Animal implements Speakable {

    public Bird(String name) {
        super(name);
    }

    abstract void fly();

    public void speak() {
        System.out.println(this.name + " sings!!!");
    }

}
