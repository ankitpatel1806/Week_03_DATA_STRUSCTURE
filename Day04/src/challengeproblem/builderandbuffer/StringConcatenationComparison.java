package challengeproblem.builderandbuffer;
import java.lang.*;
import java.util.Scanner;
public class StringConcatenationComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iterations = 1000000;
        String str = sc.nextLine();

        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + " milliseconds");
    }
}
