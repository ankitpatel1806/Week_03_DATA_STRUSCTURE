package filereader.countoccurenceofword;
import java.io.*;
public class WordCounter {
    public static int countWord(String fileName, String word) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String [] words = line.split("\\s+");
                for(String w : words) {
                    w = w.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    if (w.equals(word)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the File : "+e.getMessage());
        }
        return count;
    }
}
