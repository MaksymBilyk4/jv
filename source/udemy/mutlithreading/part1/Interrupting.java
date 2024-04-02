package udemy.mutlithreading.part1;

public class Interrupting {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main starts");

        JustThread justThread = new JustThread();
        justThread.start();

        Thread.sleep(100);
        justThread.interrupt();

        justThread.join();

        System.out.println("Main ends");

    }

}

class JustThread extends Thread {

    @Override
    public void run() {
        double rootSum = 0;
        for (int i = 0; i < 1000000000; i++) {
            if (isInterrupted()) {
                System.out.println("Ok. Interrupt.");
                System.out.println("Current sum is -> " + rootSum);
                return;
            }
            rootSum += Math.sqrt(i);
        }
        System.out.println("Root sum is -> " + rootSum);
    }

}
