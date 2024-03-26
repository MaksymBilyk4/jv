package gui.GUI3.task5.model;


import gui.GUI3.task5.interfaces.Transfromation;

public class Circle extends Figure implements Transfromation {

    private int radius;

    private final int initX;
    private final int initY;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        this.initX = x;
        this.initY = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void position(int x, int y) {
        if ((x < this.getX() + this.radius && x > this.getX() - this.radius) && (y < this.getY() + this.radius && x > this.getY() - this.radius))
            System.out.println("Point ( " + x + "," + y + ") - is INSIDE the circle");
        else
            System.out.println("Point ( " + x + "," + y + ") - is OUTSIDE the circle");

    }

    @Override
    public String toString() {
        return "\n" + this.name() + "\n" + "Center -> (" + this.getX() + "," + this.getY() + ")\n" + "Radius - " + this.radius;
    }

    @Override
    public String name() {
        return "Circle";
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double per() {
        return Math.PI * radius * 2;
    }

    @Override
    public void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getInitX() {
        return initX;
    }

    public int getInitY() {
        return initY;
    }


    @Override
    public void moveBack() {
        this.setX(this.initX);
        this.setY(this.initY);
    }
}
