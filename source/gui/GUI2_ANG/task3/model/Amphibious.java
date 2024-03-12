package gui.GUI2_ANG.task3.model;

import gui.GUI2_ANG.task3.interfaces.IAuto;
import gui.GUI2_ANG.task3.interfaces.IBoat;

public class Amphibious implements IAuto, IBoat {

    private boolean isWater;

    public Amphibious(boolean isWater) {
        this.isWater = isWater;
    }

    @Override
    public void move() {
        if (isWater) {
            System.out.println("Amphibious moving on water");
//            IAuto.super.move();
        } else {
            System.out.println("Amphibious moving on ground");
            //            IBoat.super.move();
        }
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }
}
