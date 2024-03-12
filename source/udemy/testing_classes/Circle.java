package udemy.testing_classes;

public class Circle extends Figure{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void drawFigure() {
        System.out.println("I am circle");
    }


}
