package test.game.model.interfaces;

import test.game.model.GameItem;
import test.game.model.enums.GameVariation;
import test.game.model.player.PaperGamer;
import test.game.model.player.RockGamer;
import test.game.model.player.ScissorsGamer;

public interface WinnerAble {

    default GameItem winDuel(GameItem opposite) {

        GameItem winItem = new GameItem();

        switch (opposite.getName()) {
            case GameVariation.PAPER:
                winItem.setName(GameVariation.SCISSORS);
                winItem.setNumericRepresentation(ScissorsGamer.numericRepresentation);
                break;
            case GameVariation.ROCK:
                winItem.setName(GameVariation.PAPER);
                winItem.setNumericRepresentation(PaperGamer.numericRepresentation);
                break;
            case GameVariation.SCISSORS:
                winItem.setName(GameVariation.ROCK);
                winItem.setNumericRepresentation(RockGamer.numericRepresentation);
                break;
        }

        return winItem;
    }

    // TODO
//    default GameItem winAll(List<GameItem> opposites);

}
