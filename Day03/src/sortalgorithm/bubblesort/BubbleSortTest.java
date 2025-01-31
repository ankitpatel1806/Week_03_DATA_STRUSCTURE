package sortalgorithm.bubblesort;
import java.util.Scanner;
public class BubbleSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Student : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the Marks of Student : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BubbleSort.bubbleSort(arr);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

}
