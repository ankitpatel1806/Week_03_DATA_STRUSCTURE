package linearsearch.firstnegetivenumber;
import java.util.Scanner;
public class FirstNegetiveNumberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = FirstNegetiveNumber.firstNegetiveNumber(arr);
        System.out.println("The first negetive number in the array is: " + result);
        sc.close();

    }
}
