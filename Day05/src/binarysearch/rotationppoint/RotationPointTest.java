package binarysearch.rotationppoint;
import java.util.*;
public class RotationPointTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] rotatedArray = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            rotatedArray[i] = sc.nextInt();
        }
        int rotationPointIndex = RotationPoint.findRotationPoint(rotatedArray);

        System.out.println("The rotation point is at index: " + rotationPointIndex);
        System.out.println("The smallest element is: " + rotatedArray[rotationPointIndex]);
    }
}
