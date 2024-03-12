package gui.GUI2_ANG.task3.model;

import gui.GUI2_ANG.task3.interfaces.IAuto;

public class Auto implements IAuto {

    private String color;

    public Auto (String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "color='" + this.color + '\'' +
                '}';
    }
}
