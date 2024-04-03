package udemy.mutlithreading.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {


    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new ArrayList<>();
        long val = value / 10;

        for (int i = 0; i < 10; i++) {
            long from = val * i + 1;
            long to = val * (i + 1);
            PartSum task = new PartSum(from, to);
            Future<Long> future = executorService.submit(task);
            futures.add(future);
        }
        for (Future<Long> res : futures) {
            sum += res.get();
        }

        executorService.shutdown();
        System.out.println("Total sum -> " + sum);
    }


}

class PartSum implements Callable<Long> {

    long from;
    long to;
    long localSum;

    public PartSum(long from, long to) {
        this.from = from;
        this.to = to;
    }


    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + this.from + " to " + this.to + " = " + this.localSum);
        return localSum;
    }
}
