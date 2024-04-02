package udemy.mutlithreading.part1;

public class Volatile extends Thread{

    volatile boolean bool = true;

    @Override
    public void run() {
        long counter = 0;
        while (bool) {
            counter++;
        }
        System.out.println("Loop is finished, counter equals ---> " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile thread = new Volatile();

        thread.start(); // volatile start

        Thread.sleep(3000); // main sleep

        System.out.println("wake up"); // main wake up

        thread.bool = false; // change bool = false in MAIN memory not cash
        thread.join();

        System.out.println("End!"); // end whole program (main thread)

    }

}
