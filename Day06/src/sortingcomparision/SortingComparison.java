package sortingcomparision;

import java.util.Random;

public class SortingComparison {
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        for (int size : datasetSizes) {
            int[] arr = generateRandomArray(size);
            long startTime, endTime;

            int[] bubbleSortArr = arr.clone();
            startTime = System.nanoTime();
            BubbleSort.sort(bubbleSortArr);
            endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime;

            // Measure time for Merge Sort
            int[] mergeSortArr = arr.clone();  // Clone array
            startTime = System.nanoTime();
            MergeSort.sort(mergeSortArr);
            endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime;

            // Measure time for Quick Sort
            int[] quickSortArr = arr.clone();  // Clone array
            startTime = System.nanoTime();
            QuickSort.sort(quickSortArr);
            endTime = System.nanoTime();
            long quickSortTime = endTime - startTime;

            // Print out the results for comparison
            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleSortTime / 1000000.0 + " ms");
            System.out.println("Merge Sort Time: " + mergeSortTime / 1000000.0 + " ms");
            System.out.println("Quick Sort Time: " + quickSortTime / 1000000.0 + " ms");
            System.out.println();
        }
    }
}
