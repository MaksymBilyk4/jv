package test.game.model.player;

import test.game.model.GameItem;
import test.game.model.enums.GameVariation;

public class ScissorsGamer extends Gamer {

    public final static int numericRepresentation = 3;

    public ScissorsGamer(String name, int age, int experienceInDays, double luckyLevel) {
        super(name, age, experienceInDays, luckyLevel);
    }

    @Override
    public GameItem play() {
        return new GameItem(GameVariation.SCISSORS, numericRepresentation);
    }

}
