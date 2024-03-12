package udemy.testing_classes;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {


    public static void main(String[] args) {

//        List<Figure> figures = new ArrayList<>();
//
//        Circle circle = new Circle(10);
//        Square square = new Square(9);
//
//        figures.add(circle);
//        figures.add(square);
//
//        for (Figure f : figures) {
//            f.drawFigure();
//        }

        Outer outer = new Outer();
        int n1 = 99, n2 = 66;

        Outer testLocal = new Outer(n1, n2);
        Outer testAnonymous = new Outer(true);

//        Frame frame = new Frame();
//        frame.setSize(640, 480);
//        frame.setVisible(true);
//
//        WindowAdapter windowAdapter = new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        };
//
//        frame.addWindowListener(windowAdapter);



    }


}
