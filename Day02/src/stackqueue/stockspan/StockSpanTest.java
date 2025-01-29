package stackqueue.stockspan;

import java.util.Arrays;
public class StockSpanTest {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = StockSpan.calculateSpan(prices);
        System.out.println("Stock prices: " + Arrays.toString(prices));
        System.out.println("Stock span: " + Arrays.toString(span));

    }
}
