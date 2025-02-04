package challenge;
import java.util.Arrays;
import java.util.Scanner;
public class SearchUtil {
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                arr[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n && arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target element: ");
        int target = sc.nextInt();


        int missing = firstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
        sc.close();
    }
}
