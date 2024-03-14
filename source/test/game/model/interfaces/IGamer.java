package test.game.model.interfaces;

import test.game.model.GameItem;
import test.game.model.enums.GameVariation;

public interface IGamer {

    default String name(int digit) {

        StringBuilder sb = new StringBuilder();

        switch (digit) {
            case 1:
                sb.append(GameVariation.ROCK);
                break;
            case 2:
                sb.append(GameVariation.PAPER);
                break;
            case 3:
                sb.append(GameVariation.SCISSORS);
                break;

        }
        return sb.toString();

    }

    GameItem play();

}
