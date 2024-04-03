package udemy.mutlithreading.part2;

import java.util.concurrent.CountDownLatch;

public class CountDownLetchEx {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStuffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market's stuff is on place");
        countDownLatch.countDown();
        System.out.println("countDownLatch -> " + countDownLatch.getCount());
    }

    private static void ready() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("everything is ready");
        countDownLatch.countDown();
        System.out.println("countDownLatch -> " + countDownLatch.getCount());
    }

    private static void open() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("MARKET IS OPEN!!!");
        countDownLatch.countDown();
        System.out.println("countDownLatch -> " + countDownLatch.getCount());
    }


    public static void main(String[] args) throws InterruptedException {

        new Friend("Max", countDownLatch);
        new Friend("Random,", countDownLatch);
        new Friend("test", countDownLatch);
        new Friend("Deb", countDownLatch);
        new Friend("Alex", countDownLatch);

        marketStuffIsOnPlace();
        ready();
        open();
    }

}

class Friend extends Thread {

    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    public void run() {
        try {
            countDownLatch.await();
            System.out.println(this.name + " started groceries");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}