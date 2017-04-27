package four;


import java.time.Duration;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.logging.Logger;


/**
 * Java 8 - retry strategy for a method {@link MethodPoller#method(Supplier)} until a condition {@link java.util.function.Predicate} is fulfilled. Retry is done (in intervals)
 * and stop when either condition is met or a maximum given duration of time in seconds has been exhausted.
 */
public class RetryWithMethodPoller {

    private static final Logger LOGGER = Logger.getLogger(RetryWithMethodPoller.class.getName());

    public static void main(String[] args) {
        MethodPoller<String> poller = new MethodPoller<>();
        String uuidThatStartsWith = poller
                .poll(Duration.ofSeconds(2), 0)
                .method(() -> UUID.randomUUID().toString()) // the block of code to repeat/poll
                .until(s -> s.startsWith("21")) // the condition here
                .execute();

        LOGGER.info(uuidThatStartsWith);
    }
}