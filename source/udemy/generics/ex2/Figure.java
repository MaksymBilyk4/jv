package udemy.generics.ex2;

public abstract class Figure extends Math implements SomethingAble {


    abstract void draw();

    public Figure(String figureName) {
        super(figureName);
    }



}
