package algos;

public class Product {

    String name;
    int price;
    int weight;

    public Product(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return " {" + name + " " + price + "$ " + weight + " lbs} ";
    }

}
