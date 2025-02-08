package searchcomparison;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    // Generate a random array of integers
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }

        return arr;
    }

    // Sort the array in ascending order (needed for binary search)
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);  // Sort the array in ascending order
        return arr;
    }
}
