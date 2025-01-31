package sortalgorithm.selcetionsort;
import java.util.Scanner;
public class SelectionSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Students : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the Students exam score : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SelectionSort.selectionsort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
