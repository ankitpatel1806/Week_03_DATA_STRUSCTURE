package filecomparison;

import java.io.File;
import java.io.IOException;

public class FileComparison {

    public static void main(String[] args) throws IOException {
        File testFile = new File("D:\\week 03\\Day06\\large_file.txt"); // Path to your large text file

        // FileReader Comparison
        FileReaderComparison fileReaderComparison = new FileReaderComparison(testFile);
        System.out.println("Starting FileReader comparison...");
        long fileReaderTime = fileReaderComparison.compare();
        System.out.println("FileReader took: " + fileReaderTime + " ms");

        // InputStreamReader Comparison
        InputStreamReaderComparison inputStreamReaderComparison = new InputStreamReaderComparison(testFile);
        System.out.println("Starting InputStreamReader comparison...");
        long inputStreamReaderTime = inputStreamReaderComparison.compare();
        System.out.println("InputStreamReader took: " + inputStreamReaderTime + " ms");
    }
}


