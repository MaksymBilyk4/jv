package gui.GUI_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {

        Map<String, List<Car>> carMap = new HashMap<>();

        String[] cars = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000"
        };


        for (int i = 0; i < cars.length; i += 3) {
            if (i % 3 == 0) {
                Car car = new Car(cars[i + 1], Integer.parseInt(cars[i + 2]));
                if (carMap.containsKey(cars[i])) {
                    carMap.get(cars[i]).add(car);
                } else {
                    List<Car> init = new ArrayList<>();
                    init.add(car);
                    carMap.put(cars[i], init);
                }
            }
        }

        Car cheapestCar = carMap.get(cars[0]).getFirst();
        String salon = "";


        for (Map.Entry<String, List<Car>> entry : carMap.entrySet()) {
            for (Car car : entry.getValue())
                if (car.getPrice() <= cheapestCar.getPrice()) {
                    cheapestCar = car;
                    salon = entry.getKey();
                }
        }

        System.out.println(carMap);
        System.out.println(cheapestCar);
        System.out.println(salon);
    }

}
