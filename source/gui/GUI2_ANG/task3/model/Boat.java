package gui.GUI2_ANG.task3.model;

import gui.GUI2_ANG.task3.interfaces.IBoat;

public class Boat implements IBoat {

    private int width;

    public Boat(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "width=" + width +
                '}';
    }
}
