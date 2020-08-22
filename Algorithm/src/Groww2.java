import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Groww2 {

    public static void main(String[] args) {
        System.out.println(findOptimumCost(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30), 0));
    }

    static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public static int findOptimumCost(List<Integer> travelDay, int dayIndex) {
        if(cache.containsKey(dayIndex)){
            return cache.get(dayIndex);
        }
        int minCost = 0;
        for(int i=dayIndex; i<travelDay.size(); i++) {
            minCost = findOptimumCost(travelDay, dayIndex+1) + 2;
            int nextDay = -1;
            boolean nextDayFound = false;
            for(int nextIndex = dayIndex+1; nextIndex < travelDay.size(); nextIndex++) {
                nextDay = nextIndex;
                if(travelDay.get(nextIndex) >= travelDay.get(dayIndex)+7) {
                    nextDayFound = true;
                    break;
                }
            }
            if(!nextDayFound) {
                nextDay = travelDay.size();
            }
            minCost = Math.min(findOptimumCost(travelDay, nextDay) + 7, minCost);



            nextDay = -1;
            nextDayFound = false;
            for(int nextIndex = dayIndex+1; nextIndex < travelDay.size(); nextIndex++) {
                nextDay = nextIndex;
                if(travelDay.get(nextIndex) >= travelDay.get(dayIndex)+30) {
                    nextDayFound = true;
                    break;
                }
            }
            if(!nextDayFound) {
                nextDay = travelDay.size();
            }
            minCost = Math.min(findOptimumCost(travelDay, nextDay) + 30, minCost);
        }
        cache.put(dayIndex, minCost);
        return minCost;
    }
}
