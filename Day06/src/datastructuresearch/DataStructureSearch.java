package datastructuresearch;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Arrays;

public class DataStructureSearch {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};

        for (int n : datasetSizes) {
            System.out.println("Dataset Size: " + n);

            // Generate dataset
            Integer[] dataset = DataGenerator.generateDataset(n);

            // Test Array Search
            System.out.println("Testing Array Search...");
            long startTime = System.nanoTime();
            ArraySearch.search(dataset, dataset[n / 2]);  // Search for a middle element
            long endTime = System.nanoTime();
            System.out.println("Array Search Time: " + (endTime - startTime) / 1000000 + " ms");

            // Test HashSet Search
            System.out.println("Testing HashSet Search...");
            startTime = System.nanoTime();
            HashSetSearch.search(new HashSet<>(Arrays.asList(dataset)), dataset[n / 2]);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000 + " ms");

            // Test TreeSet Search
            System.out.println("Testing TreeSet Search...");
            startTime = System.nanoTime();
            TreeSetSearch.search(new TreeSet<>(Arrays.asList(dataset)), dataset[n / 2]);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000 + " ms\n");
        }
    }
}
