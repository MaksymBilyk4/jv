package udemy.testing_classes;

public class Square extends Figure{

    private int side;

    public Square(int side) {
        this.side = side;
    }



    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void drawFigure() {
        System.out.println("I am square");
    }
}
