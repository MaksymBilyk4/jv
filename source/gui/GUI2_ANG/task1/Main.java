package gui.GUI2_ANG.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Square s1 = new Square(10);
        Square s2 = new Square(20);
        Square s3 = new Square(30);
        Square s4 = new Square(40);
        Square s5 = new Square(50);

        List<Square> squareList = new ArrayList<>();

        squareList.add(s1);
        squareList.add(s4);
        squareList.add(s5);
        squareList.add(s3);
        squareList.add(s2);

        System.out.println("Before sort:");
        System.out.println(squareList + "\n");

        Collections.sort(squareList);

        System.out.println("After sort (by id): ");
        System.out.println(squareList);

    }

}
