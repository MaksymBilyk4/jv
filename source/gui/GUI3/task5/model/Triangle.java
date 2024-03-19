package gui.GUI3.task5.model;

import gui.GUI3.task5.interfaces.Drawing;

public class Triangle extends Figure implements Drawing {

    private char drawChar;
    private int width;
    private int height;

    public Triangle(int x, int y, int width, int height, char drawChar) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.drawChar = drawChar;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String name() {
        return "Triangle";
    }

    @Override
    public void position(int x, int y) {
        int combinedX = this.getX() + this.width;

        if ((x > this.getX() && x <= combinedX) && (y > this.getY() && y < this.getY() + this.height))
            System.out.println("Point ( " + x + "," + y + ") - is INSIDE the rectangle");
        else
            System.out.println("Point ( " + x + "," + y + ") - is OUTSIDE the rectangle");
    }

    @Override
    public String toString() {
        return this.name() + "\nLeft high: (" + this.getX() + "," + this.getY() + ")\nWidth: " + this.width + ". Height: " + this.height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }

    @Override
    public double per() {
        return this.width + this.height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.drawChar);
            }
            System.out.println();
        }
    }

    @Override
    public void moveTo(int x, int y) {

    }

    @Override
    public void moveBack() {

    }
}
