package filecomparison;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class FileReaderComparison {

    private final File file;

    public FileReaderComparison(File file) {
        this.file = file;
    }

    public long compare() throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileReader reader = new FileReader(file)) {
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