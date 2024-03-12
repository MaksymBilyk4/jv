package gui.GUI2_ANG.task3;

import gui.GUI2_ANG.task3.model.Amphibious;
import gui.GUI2_ANG.task3.model.Auto;
import gui.GUI2_ANG.task3.model.Boat;

public class Main {

    public static void main(String[] args) {
        Auto auto = new Auto("Black");
        Boat boat = new Boat(100);
        Amphibious amphibious = new Amphibious(true);

        auto.move();
        boat.move();
        amphibious.move();
        amphibious.setWater(false);
        amphibious.move();
    }

}
