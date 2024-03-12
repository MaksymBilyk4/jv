package gui.GUI2_1.model;

public class Flecista extends Singer {

    public Flecista(String name, double hoursToPlay) {
        super(name, hoursToPlay);
        setInstrument();
        setHourlyPay();
    }

    @Override
    public void setInstrument() {
        super.setInstrument("flet");
    }

    @Override
    public void setHourlyPay() {
        super.setHourlyPay(300.0);
    }
}
