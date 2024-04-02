package udemy.mutlithreading.part1;

public class SleepJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            try {
                Thread.currentThread().setName("THREAD 1");
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        });

        Thread thread2 = new Thread(() -> {
           try {
               Thread.currentThread().setName("THREAD 333");
               for (int i = 333; i < 340; i++) {
                   System.out.println(Thread.currentThread().getName() + " --> " + i);
                   Thread.sleep(2500);
               }
           }catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        });
        System.out.println(thread1.getName() + " state ---> " + thread1.getState());
        thread1.start();
        System.out.println(thread1.getName() + " state ---> " + thread1.getState());
        thread2.start();

        thread1.join();
        System.out.println(thread1.getName() + " state ---> " + thread1.getState());
        thread2.join(); // sout Main thread will wait until those threads end
        System.out.println("Main thread");

    }

}
