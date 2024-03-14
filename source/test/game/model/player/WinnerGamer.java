package test.game.model.player;

import test.game.model.GameItem;
import test.game.model.interfaces.WinnerAble;

public class WinnerGamer extends Gamer implements WinnerAble {

    private GameItem oppositeGamer;

    public WinnerGamer(
            String name,
            int age,
            int experienceInDay,
            double luckyLevel,
            GameItem oppositeGamer
    ) {
        super(name, age, experienceInDay, luckyLevel);

        this.oppositeGamer = oppositeGamer;
    }

    @Override
    public GameItem play() {
        return winDuel(oppositeGamer);
    }

    public GameItem getOppositeGamer() {
        return oppositeGamer;
    }

    public void setOppositeGamer(GameItem oppositeGamer) {
        this.oppositeGamer = oppositeGamer;
    }
}
