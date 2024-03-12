package gui.GUI2_1.model;

public class Wiolonczelista extends Singer {

    public Wiolonczelista(String name, double hoursToPay) {
        super(name, hoursToPay);
        setInstrument();
        setHourlyPay();
    }

    @Override
    public void setInstrument() {
        super.setInstrument("wiolonczela");
    }

    @Override
    public void setHourlyPay() {
        super.setHourlyPay(250.0);
    }

}
