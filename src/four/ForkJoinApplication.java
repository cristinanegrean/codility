package four;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;


/**
 * Activate Java 8 parallelism based on threshold.
 * The fork/join framework is an implementation of the ExecutorService interface that helps you take advantage of multiple processors.
 * It is designed for work that can be broken into smaller pieces recursively.
 * The goal is to use all the available processing power to enhance the performance of your application.
 */
public class ForkJoinApplication {
    private static final long NUMBER = 10000000;

    // The size of the results under which a task is no longer is split into subtasks
    public static final long THRESHOLD = 1000;

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, NUMBER).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        long start = System.currentTimeMillis();
        long sum = new ForkJoinPool().invoke(task);
        long end = System.currentTimeMillis();
        System.out.println("Took " + (end - start) + " milliseconds to compute sum: " + sum);
    }

}
