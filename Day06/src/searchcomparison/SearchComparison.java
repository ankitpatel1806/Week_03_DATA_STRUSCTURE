package searchcomparison;
public class SearchComparison {

    public static void main(String[] args) {
        // Define different dataset sizes for comparison
        int[] datasetSizes = {1000, 10000, 1000000};

        // Loop through each dataset size to measure the search times
        for (int size : datasetSizes) {
            // Generate a random array for the current dataset size
            int[] arr = ArrayUtils.generateRandomArray(size);
            long startTime, endTime;

            // Measure time for Linear Search
            startTime = System.nanoTime();  // Start time for linear search
            int target = size / 2; // Example target element (middle value)
            LinearSearch.search(arr, target);  // Perform linear search
            endTime = System.nanoTime();  // End time
            long linearSearchTime = endTime - startTime;  // Time taken by linear search

            // Measure time for Binary Search (requires to be sorted array)
            arr = ArrayUtils.sortArray(arr);
            startTime = System.nanoTime();
            BinarySearch.search(arr, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;  // Time taken by binary search

            // Print out the results for comparison
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + " ms");
            System.out.println("Binary Search Time: " + binarySearchTime / 1000000.0 + " ms");
            System.out.println();
        }
    }
}