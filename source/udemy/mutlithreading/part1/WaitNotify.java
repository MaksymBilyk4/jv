package udemy.mutlithreading.part1;

public class WaitNotify {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        consumerThread.start();
        producerThread.start();

    }
}

class Market {

    private int breadCount = 0;

    public synchronized void getBread() {
        while (this.breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.breadCount--;
        System.out.println("Customer bought one bread. Bread left: " + this.breadCount);
        notify(); // notify worker that he can put bread
    }


    public synchronized void putBread() {
        while (this.breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.breadCount++;
        System.out.println("Bread has been added by producer");
        System.out.println("Bread count: " + this.breadCount);
        notify();
    }


    public int getBreadCount() {
        return breadCount;
    }

    public void setBreadCount(int breadCount) {
        this.breadCount = breadCount;
    }
}


class Producer implements Runnable{

    private Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            market.putBread();
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}

class Consumer implements Runnable {

    private Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}