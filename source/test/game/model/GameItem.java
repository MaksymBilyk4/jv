package test.game.model;

import test.game.model.enums.GameVariation;

public class GameItem {

    private GameVariation name;
    private int numericRepresentation;

    public GameItem(GameVariation name, int numericRepresentation) {
        this.name = name;
        this.numericRepresentation = numericRepresentation;
    }

    public GameItem () {};

    public GameVariation getName() {
        return name;
    }

    public void setName(GameVariation name) {
        this.name = name;
    }

    public int getNumericRepresentation() {
        return numericRepresentation;
    }

    public void setNumericRepresentation(int numericRepresentation) {
        this.numericRepresentation = numericRepresentation;
    }
}
