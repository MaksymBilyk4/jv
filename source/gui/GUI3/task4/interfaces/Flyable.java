package gui.GUI3.task4.interfaces;

public interface Flyable {

    String drive();

    String distance();


    static Flyable hybrid(Flyable first, Flyable second) {
        return new Flyable() {
            @Override
            public String drive() {
                return first.drive() + second.drive();
            }

            @Override
            public String distance() {
                return Double.parseDouble(first.distance()) > Double.parseDouble(second.distance()) ? first.distance() : second.distance();
            }
        };
    }

}
