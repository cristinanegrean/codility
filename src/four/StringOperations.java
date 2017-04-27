package four;


import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.logging.Logger;

/** That code challenge from Blue Harvest. */
public class StringOperations {

    private static final Logger LOGGER = Logger.getLogger(StringOperations.class.getName());

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LOGGER.info("Enter a word: ");
        String input = scan.nextLine();
        LOGGER.info(String.format("your input: %s", input));

        // dummy stopwatch for old school
        ZonedDateTime startChrono = getNow();
        // Do the compute with 2 Iterations
        LOGGER.info(String.format("result hasDistinctCharsTwoIterations(): %b", hasDistinctCharsTwoIterations(input)));
        LOGGER.info(String.format("2 iterations with break on non-distinct found, millis: %d%n", startChrono.until(getNow(), ChronoUnit.MILLIS)));

        // dummy stopwatch for compute based on Java 8 IntStream distinct count
        startChrono = getNow();
        LOGGER.info(String.format("result computeHasDistinctCharsWithJava8(): %b", hasDistinctCharsWithJava8IntStream(input)));
        LOGGER.info(String.format("Java 8 code, millis: %d%n", startChrono.until(getNow(), ChronoUnit.MILLIS)));
    }

    public static boolean hasDistinctCharsTwoIterations(String input) {
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i+1; j < charArray.length; j++) {
                 if (charArray[i] == charArray[j]) {
                     return false;
                 }
            }
        }
        return true;
    }

    public static boolean hasDistinctCharsWithJava8IntStream(String input) {
        return input.length() == input.chars().distinct().count();
    }

    public static ZonedDateTime getNow() {
        return ZonedDateTime.now();
    }

}
