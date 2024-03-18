package udemy.lambda.test_supplier_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static List<Car> createThreeCars(Supplier<Car> carSupplier) {
        List<Car> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(carSupplier.get());
        }

        return list;

    }

    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }


    public static void main(String[] args) {

        List<Car> cars = Main.createThreeCars(() -> new Car("Black", "Mercedes", 2.1));
        System.out.println(cars);


        Main.changeCar(cars.get(0), car -> car.setColor("White"));
        System.out.println(cars);


        List<String> strings = List.of("Hello", "World", "Java", "C++", "JavaScript", "Kotlin");

//        for (String s: strings) System.out.println(s);
        strings.forEach(str -> System.out.print(str + " "));
        

    }

}


class Car {

    private String color;
    private String model;
    private double engine;

    public Car(String color, String model, double engine) {
        this.color = color;
        this.model = model;
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }

}