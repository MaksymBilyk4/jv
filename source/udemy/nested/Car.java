package udemy.nested;

public class Car {

    protected String color;
    protected int doorCount;
    protected Engine engine;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    public static class Engine {

        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }
}


class Test {

    public static void main(String[] args) {

        Car.Engine engine = new Car.Engine(1000);
        Car car = new Car("Black", 4, engine);
        System.out.println(car);

    }

}