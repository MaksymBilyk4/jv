package udemy.mutlithreading.part1;

public class DaemonEx {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main starts");
        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

//        userThread.join();
//        daemonThread.join();

        System.out.println("Main ends");

    }

}

class UserThread extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("user_thread");
        System.out.println(Thread.currentThread().getName() + " is daemon: " + Thread.currentThread().isDaemon());
        for (char c = 'A'; c < 'D'; c++)
            System.out.println(c);
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("daemon_thread");
        System.out.println(Thread.currentThread().getName() + " is daemon: " + Thread.currentThread().isDaemon());
        for (int i = 0; i < 10000; i++)
            System.out.println(i);
    }
}