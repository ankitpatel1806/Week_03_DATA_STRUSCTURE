package stringbuffer.comparestring;

public class PerformanceComparator {
    public static void comparePerformance(int iterations) {
        String str = "hello";

        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }

        long endTimeBuffer = System.nanoTime();
        long timeTakenBuffer = endTimeBuffer - startTimeBuffer;

        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }

        long endTimeBuilder = System.nanoTime();
        long timeTakenBuilder = endTimeBuilder - startTimeBuilder;

        System.out.println("StringBuffer Time Taken: " + timeTakenBuffer + " ns");
        System.out.println("StringBuilder Time Taken: " + timeTakenBuilder + " ns");
        if (timeTakenBuffer < timeTakenBuilder) {
            System.out.println("StringBuffer is faster.");
        } else if (timeTakenBuffer > timeTakenBuilder) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("Both StringBuffer and StringBuilder took the same time.");
        }
    }
}
