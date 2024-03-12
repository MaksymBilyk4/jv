package gui.GUI2_1.model;

public class Skrzypek extends Singer {

    public Skrzypek(String name, double hoursToPlay) {
        super(name, hoursToPlay);
        setInstrument();
        setHourlyPay();
    }

    @Override
    public void setInstrument() {
        super.setInstrument("skrzypce");
    }

    @Override
    public void setHourlyPay() {
        super.setHourlyPay(200.0);
    }

}
