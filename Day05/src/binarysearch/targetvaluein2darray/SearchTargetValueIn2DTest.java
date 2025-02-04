package binarysearch.targetvaluein2darray;
import java.util.Scanner;
public class SearchTargetValueIn2DTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();
        boolean result = SearchTargetValueIn2D.searchMatrix(matrix, target);
        System.out.println("Result: " + result);
        sc.close();
    }

}
