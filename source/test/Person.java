package test;

class Test {

    public static void main(String[] args) {

        Person person = new Person("Maksym");
        person.talk(
                (text) -> System.out.println(person.getName() + " is speaking: " + text),
                "hello world"
        );

        B.test();

        C c = new C();
        c.abc();
    }

}

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void talk(Speakable speakable, String text) {
        speakable.speak(text);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


interface Speakable {

    void speak(String text);

}

interface A {
    void abc();

    default void xyz() {
        System.out.println("XYZ 1");
    }

}

interface B {
    void abc();

    public final static int a =1;

    default void xyz() {
        System.out.println("XYZ 2");
    }

    static void test() {
        System.out.println("Static method in interface");
    }

}

class C implements A, B {


    @Override
    public void abc() {
        System.out.println("Hello world");
    }

    @Override
    public void xyz() {
        A.super.xyz();
        B.super.xyz();
    }


}

