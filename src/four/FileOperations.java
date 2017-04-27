package four;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Stream;


/** Read all lines from a file as a {@code Stream} with Java 7 {@link Files}. */
public class FileOperations {

    private static final Logger LOGGER = Logger.getLogger(FileOperations.class.getName());

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        LOGGER.info("Enter full file path to file");
        String fileInputPath = scan.nextLine();
        File file = new File(fileInputPath); // /Users/cristina/Downloads/activity-mapping.csv
        if (!file.exists()) {
            LOGGER.info(String.format("File with path %s was not found", fileInputPath));
            return;
        }

        LOGGER.info("Enter data separator character i.e , (comma) or ; (semicolon)");
        String separator = scan.nextLine();

        LOGGER.info("Enter header line");
        String header = scan.nextLine(); // xmcare activity id

        Map<String, String> store = new HashMap<String, String>();

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.distinct() // skip possible duplicate lines
                  .filter(line -> !(line.startsWith(separator) || line.startsWith(header))) // skip empty lines and header
                  .map(line -> Arrays.asList(line.split(separator)))
                  .filter(list -> list.size() > 1) // skip lines with only one column
                  .forEach(list -> store.put(list.get(0), list.get(1))); // store key,value pair
        } catch (IOException e) {
            LOGGER.severe("File processing error");
        }

        LOGGER.info("Activity mapping store: " + store);
        LOGGER.info(String.format("Total mapping lines: %d", store.keySet().size()));
    }
}