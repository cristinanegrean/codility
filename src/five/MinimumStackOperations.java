package five;

import java.util.logging.Logger;

/**
 * Show how {@link MinimumStack} would perform the following operations:
 * push 15, push 10, push 12, push 11, push 7, min, push 2, push 5, push 1, min, pop, pop, pop, pop, min, pop, min, pop.
 */
public class MinimumStackOperations {

    private static final Logger LOGGER = Logger.getLogger(MinimumStackOperations.class.getName());
    private static final String LIST_MIN = "%d";

    public static void main(String[] args) {
        MinimumStack minStack = new MinimumStack();
        minStack.push(15);
        minStack.push(10);
        minStack.push(12);
        minStack.push(11);
        minStack.push(7);
        LOGGER.info(String.format(LIST_MIN, minStack.min()));
        assert 7 == minStack.min();
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        LOGGER.info(String.format(LIST_MIN, minStack.min()));
        assert 1 == minStack.min();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        LOGGER.info(String.format(LIST_MIN, minStack.min()));
        assert 10 == minStack.min();
        minStack.pop();
        LOGGER.info(String.format(LIST_MIN, minStack.min()));
        assert 10 == minStack.min();
        minStack.pop();
    }
}
