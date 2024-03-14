package test.game.model.player;

import test.game.model.GameItem;
import test.game.model.interfaces.RandomAble;

public class RandomPlayer extends Gamer implements RandomAble {

    public RandomPlayer(String name, int age, int experienceInDays, double luckyLevel) {
        super(name, age, experienceInDays, luckyLevel);
    }

    @Override
    public GameItem play() {
        return random();
    }

}
