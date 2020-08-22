import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuySell {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(2);
        a.add(50);
        a.add(36);
        a.add(100);
        a.add(20);
        a.add(100);

        System.out.println(new StockBuySell().getProfit(a));
    }

    private int getProfit(List<Integer> price) {
        List<Integer> maxPrice = new ArrayList<>(price);
        for(int i=price.size()-2; i>=0; i--){
            maxPrice.set(i, Math.max(maxPrice.get(i), maxPrice.get(i+1)));
        }
        System.out.println(price);
        System.out.println(maxPrice);
        int stocks_count = 0;
        int spent = 0;
        int profit = 0;
        for (int i=0; i<price.size(); i++) {
            if (price.get(i) < maxPrice.get(i)){
                System.out.println("Buy at i=" + i);
                stocks_count++;
                spent+= price.get(i);
            }

            if (price.get(i).equals(maxPrice.get(i)) &&  stocks_count>0) {
                System.out.println("Sell at i=" + i);
                profit += stocks_count*price.get(i) - spent;
                stocks_count = 0;
                spent = 0;
            }
        }
        return profit;
    }
}
