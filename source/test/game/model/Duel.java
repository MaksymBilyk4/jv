package test.game.model;

import test.game.model.player.Gamer;
import test.game.model.player.WinnerGamer;

public class Duel {

    private int roundCount;
    private int currentRound = 0;

    private Gamer firstGamer;
    private int firstGamerScore = 0;

    private Gamer secondGamer;
    private int secondGamerScore = 0;


    public Duel(int roundCount, Gamer firstGamer, Gamer secondGamer) {
        this.roundCount = roundCount;
        this.firstGamer = firstGamer;
        this.secondGamer = secondGamer;
    }

//    public Gamer () {
//
//    }
    

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public Gamer getFirstGamer() {
        return firstGamer;
    }

    public void setFirstGamer(Gamer firstGamer) {
        this.firstGamer = firstGamer;
    }

    public int getFirstGamerScore() {
        return firstGamerScore;
    }

    public void setFirstGamerScore(int firstGamerScore) {
        this.firstGamerScore = firstGamerScore;
    }

    public Gamer getSecondGamer() {
        return secondGamer;
    }

    public void setSecondGamer(Gamer secondGamer) {
        this.secondGamer = secondGamer;
    }

    public int getSecondGamerScore() {
        return secondGamerScore;
    }

    public void setSecondGamerScore(int secondGamerScore) {
        this.secondGamerScore = secondGamerScore;
    }

    @Override
    public String toString() {
        return "Duel{" +
                "roundCount=" + roundCount +
                ", currentRound=" + currentRound +
                ", firstGamer=" + firstGamer +
                ", firstGamerScore=" + firstGamerScore +
                ", secondGamer=" + secondGamer +
                ", secondGamerScore=" + secondGamerScore +
                '}';
    }
}
