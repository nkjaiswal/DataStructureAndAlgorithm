import java.util.Arrays;
import java.util.List;

public class BNYMRodCuttingWithCostOfCutting {
    public static void main(String[] args) {
        System.out.println(maxProfit(25, 1, Arrays.asList(20, 40, 21, 20, 20, 20, 20, 20, 20)));
    }

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        System.out.println(costPerCut);
        System.out.println(salePrice);
        System.out.println(lengths);
        int cutSize = findMaxLength(lengths);
        int maxProfit = Integer.MIN_VALUE;

        while (cutSize > 0) {
            int profit = 0;
            for (Integer length: lengths) {
                int cost = getUniformCutsCount(length, cutSize) * salePrice * cutSize - costPerCut * getCutCount(length, cutSize);
                profit += Math.max(cost, 0);
            }
            maxProfit = Math.max(maxProfit, profit);
            cutSize = getNextCutSize(cutSize);
        }
        return maxProfit;
    }

    private static int getUniformCutsCount(int length, int size) {
        return length / size;
    }
    private static int findMaxLength(List<Integer> lengths) {
        return lengths.stream().max(Integer::compareTo).get();
    }
    private static int getNextCutSize(int n) {
        return n-1;
    }
    private static int getCutCount(int length, int size) {
        if (length % size == 0){
            return length/size-1;
        } else {
            return length/size;
        }
    }
}
