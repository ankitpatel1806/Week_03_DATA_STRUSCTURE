package stackqueue.circulartour;
import java.util.*;
public class CircularTourTest {
    public static void main(String[] args) {
        int petrol[] = {4, 6, 7, 4};
        int distance[] = {6, 5, 3, 5};
        int result = CircularTour.tour(petrol, distance);
        if (result == -1) {
            System.out.println("No Valid start point");
        } else {
            System.out.println("Starting point is at pump index " + result);
        }
    }
}
