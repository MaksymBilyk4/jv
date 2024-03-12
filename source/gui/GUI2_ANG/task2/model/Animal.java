package gui.GUI2_ANG.task2.model;
import gui.GUI2_ANG.task2.interface1.IAnimalBehaviour;

// Logically  should be abstract class
public class Animal implements IAnimalBehaviour {

    // possibly do it as an enum ( DOG | CAT | FISH ) etc
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("I am animal. I can move");
    }

    @Override
    public void speak() {
        System.out.println("I am animal. I can speak, but not in all cases");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
