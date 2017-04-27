package four;


import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;


public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private static final Logger LOGGER = Logger.getLogger(ForkJoinSumCalculator.class.getName());

    // Array numbers to be summed
    private final long[] numbers;

    // the initial and final positions of the portion of the array processed by this subtask
    private final int start;
    private final int end;

    /** Public constructor used to create the main task. */
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    /** Private constructor used to recursively create subtasks of the main task. */
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // the size of the portion of the array summed by this task.
        int length = end - start;

        // if the size is less than or equal to the threshold, compute the result sequentially
        if (length <= ForkJoinApplication.THRESHOLD) {
            return computeSequentially();
        }

        LOGGER.info("Compute in parallel");
        // create subtask to sum the first half of the array
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);

        // asynchronously execute the newly created subtask using another thread of the ForkJoinPool
        leftTask.fork();

        // create subtask to sum the second half of the array
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);

        // execute this task synchronously, potentially allowing further recursive splits
        Long rightResult = rightTask.compute();
        // read the result of the first subtask or wait for it, if it isn't ready
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        LOGGER.info("Compute sequentially");
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
