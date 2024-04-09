package gui.GUI_5.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class IterNap implements Iterable<Character> {


    private int currentPosition;
    private int iterationStep;

    private String text;

    public IterNap(String text) {
        this.text = text;
        this.currentPosition = 0;
        this.iterationStep = 1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIterationStart(int index) {
        this.currentPosition = index;
    }

    public void setIterationStep(int index) {
        if (index < 1) throw new IllegalArgumentException();
        this.iterationStep = index;
    }

    @Override
    public String toString() {
        return "IterNap{" +
                "text='" + text + '\'' +
                '}';
    }


    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return currentPosition < text.length();
            }

            @Override
            public Character next() {
                if (!hasNext()) throw new NoSuchElementException();
                Character element = text.charAt(currentPosition);
                currentPosition += iterationStep;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Character> action) {
        Iterable.super.forEach(action);
    }
}
