package udemy.mutlithreading.part1;

public class DeadLockEx {

    public final static Object lock1 = new Object();
    public final static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
    /*
           DEAD-LOCK: (infinite waiting with no action)

        Thread-1 Try to get monitor 2
        Got monitor 2
        Thread-0 Try to get monitor 1

        Thread-1 Try to get monitor 1
        Got monitor 1
        Thread-0 Try to get monitor 2
    */
    // live lock - infinite actions within 2+ threads with no result
    // lock starvation - when threads with low priority are waiting to do something, but they don't know will they do their actions or not

}

class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + " Try to get monitor 1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Got monitor 1");
            System.out.println(this.getName() + "Try to get monitor 2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Monitors 1 and 2 - got");
            }
        }
    }
}

class Thread20 extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + "Try to get monitor 2");
        synchronized (DeadLockEx.lock2) {
            System.out.println("Got monitor 2");
            System.out.println(this.getName() + "Try to get monitor 1");
            synchronized (DeadLockEx.lock1) {
                System.out.println("Monitors 1 and 2 - got");
            }
        }
    }
}