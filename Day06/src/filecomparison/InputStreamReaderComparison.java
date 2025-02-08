package filecomparison;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;

public class InputStreamReaderComparison {

    private final File file;

    public InputStreamReaderComparison(File file) {
        this.file = file;
    }

    public long compare() throws IOException {
        long startTime = System.currentTimeMillis();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                // Simulate processing of the read characters
            }
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}