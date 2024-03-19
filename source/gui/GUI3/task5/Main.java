package gui.GUI3.task5;

import gui.GUI3.task5.model.Circle;
import gui.GUI3.task5.model.Figure;
import gui.GUI3.task5.model.Triangle;

public class Main {

    public static void main(String[] args) {

        Figure fig[] = new Figure[2];
        fig[0] = new Circle(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Triangle(20, 20, 15, 10, '*');    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10

        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
        // a nie z klasy Figura
        for (Figure f : fig) {
            System.out.println(f);    // System.out.println(f.toString());
            System.out.println("AreaL: " + f.area() + ". Per: " + f.per() + "\n");
        }      // pętla for-each

        fig[0].position(12, 12);
        fig[1].position(25, 30);

        Figure p2 = new Triangle(20, 20, 10, 5, '*');
        ((Triangle) p2).draw();

        fig[0].moveTo(50,40);
        System.out.println(fig[0]);

        fig[0].moveBack();
        System.out.println(fig[0]);
    }

}
