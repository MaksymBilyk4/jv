package test.testAbstract.interfaces;

public interface Speakable {

    default void speak() {
        System.out.println("Somebody speaks");
    }

}
