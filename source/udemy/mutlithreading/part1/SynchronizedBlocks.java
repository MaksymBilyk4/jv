package udemy.mutlithreading.part1;

public class SynchronizedBlocks {

    private static final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype call ends");
        }
    }

    void whatsAppCall() {
        synchronized (lock) {
            System.out.println("Whats App call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Whats App call ends");
        }
    }

    public static void main(String[] args) {
        Thread mobileThread = new Thread(new MobileRunnable());
        Thread skypeThread = new Thread(new SkypeRunnable());
        Thread whatsAppThread = new Thread(new WhatsAppRunnable());

        mobileThread.start();
        skypeThread.start();
        whatsAppThread.start();

    }

}

class MobileRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedBlocks().mobileCall();
    }

}

class SkypeRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedBlocks().skypeCall();
    }

}

class WhatsAppRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedBlocks().whatsAppCall();
    }

}