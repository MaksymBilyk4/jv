package udemy.generics.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {

    private String name;

    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T p) {
        this.participants.add(p);
        System.out.println("New member " + p.getName() + ". Team -> " + this.name);
    }

    public void playWith(Team<T> team) {
        Random random = new Random();
        String winnerName = random.nextInt(2) == 0 ? this.name : team.getName();

        System.out.println("Winner teams ----> " + winnerName);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getParticipants() {
        return participants;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }
}
