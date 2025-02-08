package datastructuresearch;
import java.util.Random;

public class DataGenerator {

    public static Integer[] generateDataset(int size) {
        Random rand = new Random();
        Integer[] dataset = new Integer[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size);  // Random numbers between 0 and size-1
        }
        return dataset;
    }
}