package udemy.mutlithreading.part2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {

    public static void main(String[] args) {

        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friendAction1 = new ArrayList<>();
        friendAction1.add(Action.SCISSORS);
        friendAction1.add(Action.PAPER);
        friendAction1.add(Action.SCISSORS);

        List<Action> friendAction2 = new ArrayList<>();
        friendAction2.add(Action.PAPER);
        friendAction2.add(Action.ROCK);
        friendAction2.add(Action.ROCK);

        new Player("Maksym", friendAction1, exchanger);
        new Player("Bohdan", friendAction2, exchanger);
    }

}

enum Action {

    ROCK,

    PAPER,

    SCISSORS

}

class Player extends Thread {

    private String name;
    private List<Action> actions;
    private Exchanger<Action> exchanger;

    public Player(String name, List<Action> actions, Exchanger<Action> exchanger) {
        this.name = name;
        this.actions = actions;
        this.exchanger = exchanger;
        this.start();
    }

    public void whoWins (Action myAction, Action friendsActions) {
        if (
                myAction == Action.PAPER && friendsActions == Action.ROCK ||
                myAction == Action.SCISSORS && friendsActions == Action.PAPER ||
                myAction == Action.ROCK && friendsActions == Action.SCISSORS
        ) System.out.println(this.name + " wins!!!");

    }

    @Override
    public void run() {
        Action reply;
        for (Action action : this.actions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
