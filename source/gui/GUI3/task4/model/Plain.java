package gui.GUI3.task4.model;

import gui.GUI3.task4.interfaces.Flyable;
import gui.GUI3.task4.interfaces.Speakable;

public class Plain implements Flyable, Speakable {

    private String model;

    public Plain(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String drive() {
        return "Plain";
    }

    @Override
    public String distance() {
        return "10000";
    }

    @Override
    public String speak() {
        return "Plain-Speaks"+this.model;
    }


}
