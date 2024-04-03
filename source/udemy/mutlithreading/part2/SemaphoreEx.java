package udemy.mutlithreading.part2;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {

    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        Person p1 = new Person("Max", callBox);
        Person p2 = new Person("Alex", callBox);
        Person p3 = new Person("Random", callBox);
        Person p4 = new Person("Artem", callBox);
        Person p5 = new Person("Bohdan", callBox);

    }

}

class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    public void run() {

        try {
            System.out.println(this.name + " waiting...");
            callBox.acquire();
            System.out.println(this.name + " uses telephone");
            sleep(2000);
            System.out.println(this.name + " finished call");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            callBox.release();
        }

    }

}
