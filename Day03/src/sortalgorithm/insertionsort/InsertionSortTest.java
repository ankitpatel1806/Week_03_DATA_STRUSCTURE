package sortalgorithm.insertionsort;
import java.util.Scanner;
public class InsertionSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Employee : ");
        int n = sc.nextInt();
        int[] employeeArr = new int[n];
        System.out.print("Enter the Employee ID : ");
        for (int i = 0; i < n; i++) {
            employeeArr[i] = sc.nextInt();
        }
        InsertionSort.insertionSort(employeeArr);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(employeeArr[i] + " ");
        }
        sc.close();
    }
}
