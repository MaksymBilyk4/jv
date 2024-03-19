package gui.GUI3.task4.model;

import gui.GUI3.task4.interfaces.Flyable;
import gui.GUI3.task4.interfaces.Speakable;

public class Bird implements Speakable, Flyable {

    private String type;

    public Bird(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String drive() {
        return "Bird";
    }

    @Override
    public String distance() {
        return "10";
    }

    @Override
    public String speak() {
        return "I am singing!!" + this.type;
    }
}
