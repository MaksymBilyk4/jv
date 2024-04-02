package udemy.mutlithreading.part1;

public class Creating {

    public static void main(String[] args) {

//        MyThread1 myThread1 = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//
//        myThread1.start();
//        myThread2.start();

        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new MyThread4());

        new Thread(() -> {
            for (int i = -100; i < 0; i++)
                System.out.println(i);
        }).start();

        thread1.start();
        thread2.start();

    }

}


class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++)
            System.out.println(i);
    }

}

class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 100; i >= 0; i--)
            System.out.println(i);
    }

}

class MyThread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 100; i >= 0; i--)
            System.out.println(i);
    }

}

class MyThread4 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++)
            System.out.println(i);
    }
}