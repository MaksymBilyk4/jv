package udemy.mutlithreading.part1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        new Employee("Max", lock);
        new Employee("Den", lock);
        new Employee("Bohdan", lock);


        Thread.sleep(4000);
        new Employee("Artem", lock);
        new Employee("Alex", lock);

    }

}

class Employee extends Thread {

    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {
        if (lock.tryLock()) {
            try {
                System.out.println(name + " uses ATM");
                Thread.sleep(2000);
                System.out.println(name + " finished using ATM");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(this.name + " don't want to wait");
        }
    }

}