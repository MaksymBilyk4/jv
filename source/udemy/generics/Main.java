package udemy.generics;

import udemy.generics.ex1.Info;
import udemy.generics.ex2.*;
import udemy.generics.ex2.Math;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


//        Info<String> stringInfo = new Info<>("Hello");
//        System.out.println(stringInfo);
//        Info<Integer> integerInfo = new Info<>(369);
//        System.out.println(integerInfo);
//
//        List<Info<String>> infos = List.of(new Info<>("Hello"), new Info<>("World"), new Info<>("Something"));
//
//        System.out.println(getSecondElement(infos));


        FiguresCollection<Figure> figuresCollection = new FiguresCollection<>();
        figuresCollection.addFigure(new Circle(10));
        figuresCollection.addFigure(new Rectangle(3, 6));
        System.out.println(figuresCollection.figures);
        displayFiguresName(figuresCollection.figures);



        List<Math> figuresCollection1 = new ArrayList<>() {};
        figuresCollection1.add(new Vector2d(1, 2));
        figuresCollection1.add(new Circle(4));
//        displayFigureNameInterface(figuresCollection1); - error because Vector2D - is not implementing SomethingAble

        // if we are doing something like this ---> error because of in class FiguresCollection<F> -> F extends Figure
//        figuresCollection.addFigure(new Vector2d(2,3));

    }


    // TYPE ERASURE ==================================================================================================

//    public void abc(Info<String> stringInfo) {
//        String s = stringInfo.getValue();
//    }
//
//    public void abc(Info<Integer> integerInfo) {
//        int a = integerInfo.getValue();
//    }

    // JVM: public void abc(Info info)


    public static <T> T getSecondElement(List<T> list) {
        return list.get(1);
    }

    public static <T extends Figure & SomethingAble> void displayFiguresName(List<T> figures) {
        figures.forEach(f -> System.out.println("Figure ---> " + f.getElementName() + " !!!!"));
    }

    public static <T extends Math & SomethingAble> void displayFigureNameInterface(List<T> something) {
        something.forEach(f -> System.out.println("Math -> " + f.getElementName()));
    }

}
