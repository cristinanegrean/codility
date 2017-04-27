package four;


import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;


/** A show-case for Java 8 fuctional interfaces {@link Supplier} and {@link Predicate} */
public class MethodPoller<T> {

    private static final Logger LOGGER = Logger.getLogger(MethodPoller.class.getName());

    private Supplier<T>  pollMethod;
    private Predicate<T> pollResultPredicate;
    private Duration     maxDurationSeconds;
    private int          pollDelayMillis;

    public MethodPoller<T> poll(Duration maxDuration, int delayMillis) {
        maxDurationSeconds = maxDuration;
        pollDelayMillis = delayMillis;
        return this;
    }

    public MethodPoller<T> method(Supplier<T> supplier) {
        pollMethod = supplier;
        return this;
    }

    public MethodPoller<T> until(Predicate<T> predicate) {
        pollResultPredicate = predicate;
        return this;
    }

    public T execute() {
        // Validate that method and until have been called and poll duration set
        if (pollResultPredicate == null || pollMethod == null || maxDurationSeconds == null) {
            return null;
        }

        T result = null;
        boolean pollSucceeded = false;

        ZonedDateTime startChrono = getNow();
        while (!pollSucceeded && getNow().isBefore(startChrono.plusSeconds(maxDurationSeconds.getSeconds()))) {
            result = pollMethod.get();
            pollSucceeded = pollResultPredicate.test(result);

            try {
                TimeUnit.MILLISECONDS.sleep(pollDelayMillis);
            } catch (InterruptedException e) {
                LOGGER.info(String.format("InterruptedException, method poll result is %s", result));
            }
        }

        return result;
    }

    public static ZonedDateTime getNow() {
        return ZonedDateTime.now();
    }
}