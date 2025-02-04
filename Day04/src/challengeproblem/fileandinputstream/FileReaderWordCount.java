package challengeproblem.fileandinputstream;
import java.io.*;
public class FileReaderWordCount {
    public static void main(String[] args) {
        String filePath = "D:\\week 03\\Day04_Builder_Buffer\\Testpart.txt";
        int wordCount = 0;

        long startTime = System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace as delimiter
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Total words in the file: " + wordCount);
        System.out.println("Time taken to read the file and count words: " + (endTime - startTime) + " milliseconds");
    }
}
