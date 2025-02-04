package binarysearch.findfirstlastoccurrence;

public class FindFirstLastOccurrence {
    public static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = {-1, -1};

        result[0] = findFirstOccurrence(arr, target);
        if (result[0] != -1) {
            result[1] = findLastOccurrence(arr, target);
        }

        return result;
    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return first;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return last;
    }
}
