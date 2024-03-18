package udemy.generics.ex2;

public class Circle extends Figure{

    private int radius;

    public Circle(int radius) {
        super("Circle");

    }

    @Override
    void draw() {
        System.out.println("Draw " + this.elementName + ". Radius: " + this.radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void abc() {
        System.out.println("Circe abc");
    }
}
