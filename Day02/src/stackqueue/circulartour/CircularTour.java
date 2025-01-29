package stackqueue.circulartour;
import java.util.*;
public class CircularTour {
    public static int tour(int petrol[], int distance[]) {
        int n = petrol.length;
        int start = 0, end = 1;
        int curr_petrol = petrol[start] - distance[start];
        while (start != end || curr_petrol < 0) {
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= petrol[start] - distance[start];
                start = (start + 1) % n;
                if (start == 0) return -1;
            }
            curr_petrol += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start;
    }
}
