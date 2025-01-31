package sortalgorithm.countingsort;
import java.util.Scanner;
public class CountingSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Age of Students : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        CountingSort cs = new CountingSort();
        cs.countingSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
