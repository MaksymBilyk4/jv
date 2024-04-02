package udemy.mutlithreading.part1;

public class DataRace {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Th());
        Thread thread2 = new Thread(new Th());
        Thread thread3 = new Thread(new Th());

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Count {
    static int counter = 0;

//    public static void  increment() {
//        Count.counter++;
//        System.out.print(Count.counter + " ");
//    }

    public static synchronized void increment() { // threads are synchronized
        Count.counter++;
        System.out.print(Count.counter + " ");
    }
}

class Th implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Count.increment();
        }
    }
}
