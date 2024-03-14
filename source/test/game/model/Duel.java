package test.game.model;

import java.util.HashMap;

public class Duel<G1, G2> {

    private int roundCount;
    private int currentRound = 0;

    private G1 firstGamer;
    private int firstGamerScore = 0;

    private G2 secondGamer;
    private int secondGamerScore = 0;


    public Duel(int roundCount, G1 firstGamer, G2 secondGamer) {
        this.roundCount = roundCount;
        this.firstGamer = firstGamer;
        this.secondGamer = secondGamer;
    }

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

    public G1 getFirstGamer() {
        return firstGamer;
    }

    public void setFirstGamer(G1 firstGamer) {
        this.firstGamer = firstGamer;
    }

    public int getFirstGamerScore() {
        return firstGamerScore;
    }

    public void setFirstGamerScore(int firstGamerScore) {
        this.firstGamerScore = firstGamerScore;
    }

    public G2 getSecondGamer() {
        return secondGamer;
    }

    public void setSecondGamer(G2 secondGamer) {
        this.secondGamer = secondGamer;
    }

    public int getSecondGamerScore() {
        return secondGamerScore;
    }

    public void setSecondGamerScore(int secondGamerScore) {
        this.secondGamerScore = secondGamerScore;
    }
}
