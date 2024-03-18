package test.game.model.player;

import test.game.model.GameItem;
import test.game.model.enums.GameVariation;

import java.util.Scanner;

public class Player extends Gamer {

    public Player(String name, int age, int experienceIdDays, double luckyLevel) {
        super(name, age, experienceIdDays, luckyLevel);
    }

    @Override
    public GameItem play() {

        Scanner scanner = new Scanner(System.in);
        GameItem userGameItem = null;

        int userChoice = 0;

        while (userGameItem == null) {
            System.out.println(
                    "Input your choice in number: | " +
                            GameVariation.SCISSORS + " - " + ScissorsGamer.numericRepresentation + " | " +
                            GameVariation.ROCK + " - " + RockGamer.numericRepresentation + " | " +
                            GameVariation.PAPER + " - " + PaperGamer.numericRepresentation + " | "
            );
            userChoice = scanner.nextInt();
            userGameItem = GameItem.defineGameItem(userChoice);

            if (userGameItem == null) System.out.println("Incorrect choice. Try again");
        }

        return userGameItem;
    }


}
