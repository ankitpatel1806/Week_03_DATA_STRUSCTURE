package searchcomparison;

public class LinearSearch {

    //perform linear search
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            // Index at current iteration is equal to target
            if (arr[i] == target) {
                return i;
            }
        }
        // Target not found
        return -1;
    }
}
