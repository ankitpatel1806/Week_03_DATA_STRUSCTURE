package sortingcomparision;

public class MergeSort {


    public static void sort(int[] arr) {
        if (arr.length < 2) return; // Base case: a single element is sorted

        int mid = arr.length / 2; // Find the middle point
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy data to left and right arrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursively sort both halves
        sort(left);
        sort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    // Merge two sorted arrays
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two arrays while elements are left in both
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}