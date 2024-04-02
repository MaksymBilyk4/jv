package udemy.mutlithreading.part1;

public class NameAndPriority {

    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();

        System.out.println("Thread name = " + myThread5.getName());
        System.out.println("Thread priority = " + myThread5.getPriority());
        MyThread5 myThread6 = new MyThread5();
        myThread6.setName("SUPER_THREAD");
        myThread6.setPriority(8);
        System.out.println("Thread name = " + myThread6.getName() + " ");
        System.out.println("Thread priority = " + myThread6.getPriority());

        System.out.println("Thread: " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
    }

}

class MyThread5 extends Thread {

    @Override
    public void run() {
        System.out.println("privet");
    }

}