package sortalgorithm.mergesort;
import java.util.Scanner;
public class MergeSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Books : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the Price Of Books : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MergeSort.mergeSort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

}
