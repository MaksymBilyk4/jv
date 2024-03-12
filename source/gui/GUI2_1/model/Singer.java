package gui.GUI2_1.model;

public abstract class Singer {

    private String name;
    private double hoursToPlay; // hours

    private double hourlyPay;
    private String instrument;


    public Singer(String name, double hoursToPlay) {
        this.name = name;
        this.hoursToPlay = hoursToPlay;
    }

    public abstract void setInstrument();

    public abstract void setHourlyPay();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursToPlay() {
        return hoursToPlay;
    }

    public void setHoursToPlay(double hoursToPlay) {
        this.hoursToPlay = hoursToPlay;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {

        return "Muzyk: " + this.name + "\n" +
                "Instrument: " + this.instrument + "\n" +
                "Czas wystąpienia: " + this.hoursToPlay + "\n" +
                "Stawka godzinowa: " + this.hourlyPay + "\n";

    }

    public static Singer maxHonorarium(Singer[] singers) {

        if (singers.length == 1) return singers[0];

        Singer bestSinger = singers[0];

        for (Singer s : singers) {
            if (s.getHourlyPay() * s.getHoursToPlay() > bestSinger.getHourlyPay() * bestSinger.getHoursToPlay())
                bestSinger = s;
        }

        return bestSinger;
    }
}
