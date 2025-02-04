package inputstreamreader.userreadandwrite;
import java.io.*;

public class UserInputToFileWriter {
    public static void writeUserInputToFile(String filePath) {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in); // Read from console
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // Efficient reading
                FileWriter fileWriter = new FileWriter(filePath, true) // Append mode
        ) {
            System.out.println("Enter text to write to the file. Type 'exit' to stop.");

            String userInput;
            while (true) {
                userInput = bufferedReader.readLine(); // Read user input
                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Stop if user enters "exit"
                }
                fileWriter.write(userInput + System.lineSeparator()); // Write input to file
            }

            System.out.println("Input has been written to the file.");
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
