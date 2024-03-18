package udemy.generics.ex2;

import java.util.ArrayList;
import java.util.List;

public class FiguresCollection<F extends Figure> {

    public List<F> figures = new ArrayList<>();

    public FiguresCollection() {}

    public void addFigure(F figure) {
        this.figures.add(figure);
    }

}
