package filereader.countoccurenceofword;

import java.io.IOException;

public class WordCounterTest {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\week 03\\Day04_Builder_Buffer\\src\\filereader\\filelinereader\\stringbuliderandbuffer.txt"; // Path to the file
        String targetWord = "string"; // Word to count
        int count = WordCounter.countWord(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' occurs " + count + " times in the file.");
    }
}
