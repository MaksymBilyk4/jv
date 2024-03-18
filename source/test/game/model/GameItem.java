package test.game.model;

import test.game.model.enums.GameVariation;
import test.game.model.player.PaperGamer;
import test.game.model.player.RockGamer;
import test.game.model.player.ScissorsGamer;

public class GameItem {

    private GameVariation name;
    private int numericRepresentation;

    public GameItem(GameVariation name, int numericRepresentation) {
        this.name = name;
        this.numericRepresentation = numericRepresentation;
    }

    public GameItem () {};

    public static GameItem defineGameItem(int numericRepresentation) {

        GameItem gameItem = new GameItem();

        switch (numericRepresentation) {
            case PaperGamer.numericRepresentation:
                gameItem.setNumericRepresentation(PaperGamer.numericRepresentation);
                gameItem.setName(GameVariation.PAPER);
                break;
            case RockGamer.numericRepresentation:
                gameItem.setNumericRepresentation(RockGamer.numericRepresentation);
                gameItem.setName(GameVariation.ROCK);
                break;
            case ScissorsGamer.numericRepresentation:
                gameItem.setNumericRepresentation(ScissorsGamer.numericRepresentation);
                gameItem.setName(GameVariation.SCISSORS);
                break;
            default:
                gameItem = null;
        }

        return gameItem;
    }

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
