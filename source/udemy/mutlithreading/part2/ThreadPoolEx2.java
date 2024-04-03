package udemy.mutlithreading.part2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

//        scheduledExecutorService.schedule(new Run1(), 2, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(new Run1(), 3,1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new Run1(), 3,1000, TimeUnit.SECONDS);


        scheduledExecutorService.shutdown();
    }

}

class Run1 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begins work");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " ends work");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
