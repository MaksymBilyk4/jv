package gui.GUI_6;

public class Car {

    private String mark;

    private int price;

    public Car(String mark, int price) {
        this.mark = mark;
        this.price = price;
    }

    public Car() {}

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.mark + " " + this.price;
    }
}
