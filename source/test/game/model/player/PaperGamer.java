package test.game.model.player;

import test.game.model.GameItem;
import test.game.model.enums.GameVariation;

public class PaperGamer extends Gamer{

    public final static int numericRepresentation = 1;

    public PaperGamer (String name, int age, int experienceInDays, int luckyLevel) {
        super(name, age, experienceInDays, luckyLevel);
    }

    @Override
    public GameItem play() {
        return new GameItem(GameVariation.PAPER, numericRepresentation);
    }

}
