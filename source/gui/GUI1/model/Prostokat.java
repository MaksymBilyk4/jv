package gui.GUI1.model;


import gui.GUI1.exception.IncorrectProstokatException;

public class Prostokat {

    private int width;
    private int height;


    public Prostokat(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // kwadrat
    public Prostokat(int side) {
        this.width = side;
        this.height = side;
    }

    public void rysuj() throws IncorrectProstokatException {
        String type = this.width == this.height ? "Kwadrat" : "Prostakt";
        System.out.println(type + " rozmiaru ---> " + this.width + " x " + this.height);

        if (width <= 0 || height <= 0) throw new IncorrectProstokatException("Błędny prostokąt!");

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

}
