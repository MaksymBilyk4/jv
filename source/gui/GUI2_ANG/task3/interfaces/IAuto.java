package gui.GUI2_ANG.task3.interfaces;

public interface IAuto {

    default void move() {
        System.out.println("I am auto. Move on the ground.");
    }

}
