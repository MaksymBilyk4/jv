package gui.GUI3.task4.model;

import gui.GUI3.task4.interfaces.Flyable;

public class Virus implements Flyable {

    private String name;

    public Virus(String name) {
        this.name = name;
    }

    @Override
    public String drive() {
        return "Virus";
    }

    @Override
    public String distance() {
        return "0.03"; // km
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
