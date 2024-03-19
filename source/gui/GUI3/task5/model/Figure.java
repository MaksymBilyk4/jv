package gui.GUI3.task5.model;

import gui.GUI3.task5.interfaces.Calculation;
import gui.GUI3.task5.interfaces.Transfromation;

public abstract class Figure implements Calculation, Transfromation {

    private int x;
    private int y;


    public abstract String name();

    public abstract void position(int x, int y);


    void displayFigureName() {
        System.out.println(this.name());
    }

    @Override
    public String toString() {
        return "Figure: " + this.name() + ". Coordinates: (" + this.x + " ; " + this.y + " )";

    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
