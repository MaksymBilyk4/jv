package gui.GUI3.task4.model;

import gui.GUI3.task4.interfaces.Flyable;
import gui.GUI3.task4.interfaces.Speakable;

public class UFO implements Flyable, Speakable {

    private String color;

    public UFO(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String drive() {
        return "UFO";
    }

    @Override
    public String distance() {
        return "1000000";
    }

    @Override
    public String speak() {
        return "UFO-Speaks" + this.color;
    }
}
