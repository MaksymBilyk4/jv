package algos;

public class Attraction {

    String name;
    double takesDays;
    int rate;

    public Attraction(String name, double takesDays, int rate) {
        this.name = name;
        this.takesDays = takesDays;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return name + " " + takesDays + "d " + rate;
    }
}
