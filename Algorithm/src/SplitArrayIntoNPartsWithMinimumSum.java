import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SplitArrayIntoNPartsWithMinimumSum {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<r.nextInt(1000); i++) {
            data.add(r.nextInt(200));
        }
        System.out.println(new SplitArrayIntoNPartsWithMinimumSum().getMaxSum(data, r.nextInt(data.size())));
    }

    public int getMaxSum(List<Integer> data, int splits) {
        return getMaxSum(data, splits, 0, 0);
    }
    Map<String, Integer> cache = new HashMap<>();
    private int getMaxSum(List<Integer> data, int splits, int bIndex, int sIndex) {
        if(cache.containsKey(splits + "_" + bIndex)){
//            System.out.println("Hit");
            return cache.get(splits + "_" + bIndex);
        }
        if(splits == 0){
            int sol = data.subList(bIndex, data.size()).stream().mapToInt(Integer::intValue).sum();
            cache.put(splits + "_" + bIndex, sol);
            return sol;
        }
        int sol = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=bIndex; i<data.size(); i++) {
            sum += data.get(i);
            sol = Math.min(sol, Math.max(sum, getMaxSum(data, splits-1, i+1, sIndex+1)));
        }
//        System.out.println(data + ", " + bIndex + ", "+ sol);
        cache.put(splits + "_" + bIndex, sol);
        return sol;
    }
}
