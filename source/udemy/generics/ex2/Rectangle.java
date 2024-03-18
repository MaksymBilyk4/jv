package udemy.generics.ex2;

public class Rectangle extends Figure{

    private int w;
    private int h;

    public Rectangle(int w, int h) {
        super("Rectangle");
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + this.elementName + ". Width: " + this.w + ", Height: " + this.h);
    }

    @Override
    public void abc() {
        System.out.println("Circe abc");
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
