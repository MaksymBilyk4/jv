package gui.GUI2_ANG.task1;

public class Square implements Comparable<Square> {

    private static int counter = 0;

    private int id;
    private int length;

    public Square(int length) {
        counter++;

        this.id = counter;
        this.length = length;

    }

    public int getArea() {
        return length * length;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Square.counter = counter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Square: id = " + this.id + ", area = " + this.getArea();
    }

    @Override
    public int compareTo(Square square) {
        return this.id - square.getId();
    }

}
