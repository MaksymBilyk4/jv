package gui.GUI3.task5;

import gui.GUI3.task5.model.Circle;
import gui.GUI3.task5.model.Figure;
import gui.GUI3.task5.model.Triangle;

import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {

        Figure[] figure = {
                new Triangle(1, 1, 4, 9, '*'),
                new Circle(-1, 1, 5),
                new Triangle(2, 2, 6, 6, '*'),
        };

        System.out.println("Before sort: \n" + Arrays.toString(figure));
        Arrays.sort(figure);
        System.out.println();
        System.out.println("After sort: \n" + Arrays.toString(figure));

    }

}
