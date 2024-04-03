package udemy.mutlithreading.part2;

import java.util.concurrent.*;

public class CallableEx {

    static int factorial = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Factorial1 factorial1 = new Factorial1(0);
        Future<Integer> result = executorService.submit(factorial1);

        try {
            factorial = result.get();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }

        System.out.println(factorial);
        System.out.println("Finished");

    }

}

class Factorial1 implements Callable<Integer> {

    public int f;

    public Factorial1(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception{
        if (this.f <= 0) {
            throw new Exception("Incorrect factorial to calculate");
        }
        int result = 1;
        for (int i = 1; i <= this.f; i++) {
            result *= i;
        }
        return result;
    }
}
