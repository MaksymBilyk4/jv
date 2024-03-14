package test.game.model.interfaces;

import test.game.model.GameItem;
import test.game.model.enums.GameVariation;
import test.game.model.player.PaperGamer;
import test.game.model.player.RockGamer;
import test.game.model.player.ScissorsGamer;

public interface RandomAble {

    default GameItem random() {
        int numericRepresentation = (int) (Math.random() * 3) + 1;
        GameItem gameItem = new GameItem();

        switch (numericRepresentation) {
            case PaperGamer.numericRepresentation:
                gameItem.setName(GameVariation.PAPER);
                break;
            case RockGamer.numericRepresentation:
                gameItem.setName(GameVariation.ROCK);
                break;
            case ScissorsGamer.numericRepresentation:
                gameItem.setName(GameVariation.SCISSORS);
                break;

        }
        gameItem.setNumericRepresentation(numericRepresentation);

        return gameItem;
    }

}
